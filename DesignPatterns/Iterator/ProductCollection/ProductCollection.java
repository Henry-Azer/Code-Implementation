package DesignPatterns.Iterator.ProductCollection;

import java.util.ArrayList;
import java.util.List;

public class ProductCollection {
  protected List<Product> products = new ArrayList<>();

  public void add(Product product) {
    products.add(product);
  }

  public void remove(Product product) {
    products.remove(product);
  }

  public Iterator createIterator() {
    return new ListIterator(this);
  }
}
