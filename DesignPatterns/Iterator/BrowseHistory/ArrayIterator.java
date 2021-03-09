package DesignPatterns.Iterator.BrowseHistory;

public class ArrayIterator implements Iterator {
    private final BrowseHistory history;
    private int index;

    public ArrayIterator(BrowseHistory history) {
        this.history = history;
    }

    @Override
    public boolean hasNext() {
        return (index < history.count);
    }

    @Override
    public String current() {
         return history.urls[index];
    }

    @Override
    public void next() {
        index++;
    }
}
