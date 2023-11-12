package parts.qvm.product.helpers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.inject.Singleton;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * GenericWorkbookWriter is a utility class for generating Excel workbooks from a list of data objects.
 *
 * @author henry azer
 * @since 06/11/2023
 */
@Singleton
public class GenericWorkbookWriter {
    private static final GenericWorkbookWriter instance = new GenericWorkbookWriter();

    private GenericWorkbookWriter() {}

    public static GenericWorkbookWriter getInstance() {
        return instance;
    }

    /**
     * Generates an Excel workbook from a list of data objects.
     *
     * @param data      The list of data objects to be written to the workbook.
     * @param sheetName The name of the Excel sheet.
     * @param <T>       The type of data objects.
     * @return An `ByteArrayInputStream` containing the Excel workbook data.
     * @throws Exception If an error occurs during workbook generation.
     */
    public <T> ByteArrayInputStream write(List<T> data, String sheetName) throws Exception {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet(sheetName);
            setSheetColumnsHeaders(sheet, data.get(0).getClass());

            int rowIdx = 1;
            setSheetRowsData(data, sheet, rowIdx);

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException exception) {
            throw new Exception("Failed to import data to Excel file: " + exception.getMessage());
        }
    }

    /**
     * Sets the data rows in the Excel sheet based on the list of data objects.
     *
     * @param data   The list of data objects.
     * @param sheet  The Excel sheet to write data to.
     * @param rowIdx The starting row index for writing data.
     * @param <T>    The type of data objects.
     * @throws Exception If an error occurs during data writing.
     */
    private <T> void setSheetRowsData(List<T> data, Sheet sheet, int rowIdx) throws Exception {
        for (T reportDto : data) {
            Row row = sheet.createRow(rowIdx++);
            int cellIdx = 0;
            for (Field field : reportDto.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(reportDto);
                if (value instanceof Number) {
                    row.createCell(cellIdx++).setCellValue(((Number) value).doubleValue());
                } else if (value instanceof Date) {
                    row.createCell(cellIdx++).setCellValue((Date) value);
                } else {
                    row.createCell(cellIdx++).setCellValue(value.toString());
                }
            }
        }
    }

    /**
     * Sets the column headers in the Excel sheet.
     * Using class fields.
     *
     * @param sheet     The Excel sheet.
     * @param dataClass The column headers.
     */
    private void setSheetColumnsHeaders(Sheet sheet, Class<?> dataClass) {
        Field[] fields = dataClass.getDeclaredFields();
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < fields.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(fields[i].getName());
        }
    }
}