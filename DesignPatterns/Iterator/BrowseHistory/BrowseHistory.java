package DesignPatterns.Iterator.BrowseHistory;

public class BrowseHistory {

    protected final String[] urls = new String[10];
    protected int count;

    public void push(String url) {
        urls[count++] = url;
    }

    public String pop() {
        return urls[--count];
    }

    public Iterator createIterator() {
        return new ArrayIterator(this);
    }
}
