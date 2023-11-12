package parts.qvm.product.mapper.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

/**
 * GenericDeserializer is a class for deserializing JSON into objects of any class using Jackson.
 * It provides a generic object deserializer for any class.
 *
 * @param <T> the type of the target class.
 * @author henry azer
 * @since 31/10/2023
 */
public class GenericDeserializer<T> extends JsonDeserializer<T> {
    private final Class<T> target;

    /**
     * Constructor for the GenericDeserializer class.
     *
     * @param target The class type to which JSON should be deserialized.
     */
    public GenericDeserializer(Class<T> target) {
        this.target = target;
    }

    /**
     * Deserializes JSON data into an object of the specified class type.
     *
     * @param jsonParser             The JsonParser to read JSON data from.
     * @param deserializationContext The DeserializationContext provided by Jackson.
     * @return An instance of the target class populated with deserialized data.
     * @throws IOException If an I/O error occurs during deserialization.
     */
    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.readValueAsTree();
        Map<String, Object> fieldValues = new HashMap<>();
        Field[] fields = target.getDeclaredFields();

        // Iterate through JSON fields and map them to Java class fields
        for (int i = 0; i < node.size(); i++) {
            String fieldName = fields[i].getName();
            JsonNode fieldValue = node.get(i);
            Object mappedValue = mapFieldValueToType(fields[i].getType(), fieldValue);
            fieldValues.put(fieldName, mappedValue);
        }

        try {
            T instance = target.getDeclaredConstructor().newInstance();
            // Set field values in the instance object
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(instance, fieldValues.get(field.getName()));
            }
            return instance;
        } catch (Exception exception) {
            throw new RuntimeException("Serialization Error: Unable to serialize the data.");
        }
    }

    /**
     * Maps a JSON field value to its corresponding Java type.
     *
     * @param fieldType  The Java type of the field.
     * @param fieldValue The JSON field value to be mapped.
     * @return The mapped field value with the appropriate Java type.
     */
    private Object mapFieldValueToType(Class<?> fieldType, JsonNode fieldValue) {
        if (fieldType == int.class || fieldType == Integer.class) {
            return fieldValue.asInt();
        } else if (fieldType == long.class || fieldType == Long.class) {
            return fieldValue.asLong();
        } else if (fieldType == double.class || fieldType == Double.class) {
            return fieldValue.asDouble();
        } else if (fieldType == boolean.class || fieldType == Boolean.class) {
            return fieldValue.asBoolean();
        } else if (fieldType == String.class) {
            if (fieldValue.isNumber() && isUnixTimestamp(fieldValue.asLong())) {
                // Convert Unix timestamp to LocalDateTime
                Instant instant = Instant.ofEpochMilli(fieldValue.asLong());
                return LocalDateTime.from(instant.atZone(ZoneId.systemDefault())).toString();
            } else {
                return fieldValue.asText();
            }
        }
        return fieldValue;
    }

    /**
     * Checks if a given long value is a valid Unix timestamp.
     *
     * @param timestamp The long value to be checked.
     * @return true if the value is a valid Unix timestamp; otherwise, false.
     */
    private boolean isUnixTimestamp(long timestamp) {
        return timestamp >= 946684800L;
    }
}
