package DesignPatterns.Iterator.BrowseHistory;

public class ListIterator implements Iterator {
    private final BrowseHistory history;
    private int index;

    public ListIterator(BrowseHistory history) {
        this.history = history;
    }

    @Override
    public String current() {
//        return history.urls.get(index);
        return "";
    }

    @Override
    public void next() {
        index++;
    }

    @Override
    public boolean hasNext() {
        return (index < history.count);
    }
}
