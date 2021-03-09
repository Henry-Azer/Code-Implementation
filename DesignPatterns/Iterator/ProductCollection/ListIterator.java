package DesignPatterns.Iterator.ProductCollection;

public class ListIterator implements Iterator {
    private final ProductCollection collection;
    private int index;

    public ListIterator(ProductCollection collection) {
        this.collection = collection;
    }

    @Override
    public void next() {
        index++;
    }

    @Override
    public Product current() {
        return collection.products.get(index);
    }

    @Override
    public boolean hasNext() {
        return (index < collection.products.size());
    }
}
