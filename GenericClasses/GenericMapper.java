package parts.qvm.product.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import parts.qvm.product.mapper.deserializer.GenericDeserializer;

/**
 * GenericMapper is a class for mapping objects of any class to another class using Jackson.
 * It provides a generic object mapper for any class.
 *
 * @author Henry Azer
 * @since 31/10/2023
 */
public class GenericMapper {

    /**
     * Maps an object of one class to another class using Jackson's ObjectMapper.
     *
     * @param source The source object to be mapped.
     * @param target The target class to which the source object should be mapped.
     * @param <T>    The target class type.
     * @return The mapped object of the target class.
     * @throws RuntimeException If there's an error during the mapping process, such as JSON processing exceptions.
     */
    public static <T> T map(Object source, Class<T> target) {
        try {
            SimpleModule module = new SimpleModule();
            ObjectMapper objectMapper = new ObjectMapper();

            // Add a custom deserializer for the target class
            module.addDeserializer(target, new GenericDeserializer<>(target));
            objectMapper.registerModule(module);

            // Convert the source object to JSON and then parse it back to the target class
            return objectMapper.readValue(objectMapper.writeValueAsString(source), target);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }
}
