package DesignPatterns.Flyweight.SpreadSheet;

public class Cell {
  private final int row;
  private final int column;
  private String content;
  private CellContext cellContext;
  public Cell(int row, int column, CellContext cellContext) {
    this.row = row;
    this.column = column;
    this.cellContext = cellContext;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public CellContext getCellContext() {
    return cellContext;
  }

  public void setCellContext(CellContext cellContext) {
    this.cellContext = cellContext;
  }

  public void render() {
    System.out.printf("(%d, %d): %s [%s]\n", row, column, content, cellContext.getFontFamily());
  }
}
