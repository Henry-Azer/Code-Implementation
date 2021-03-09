package DesignPatterns.ChainOfResponsibility.DataReader;

public class DataReaderFactory {
    public static DataReader getDataReaderChain() {
        var excelReader = new ExcelReader();
        var numbersReader = new NumbersReader();
        var quickBooksReader = new QuickBooksReader();

        excelReader.setNext(null);
        numbersReader.setNext(excelReader);
        quickBooksReader.setNext(numbersReader);

        return quickBooksReader;
    }
}
