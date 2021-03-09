package DesignPatterns.Iterator.BrowseHistory;

public interface Iterator {

    String current();
    void next();
    boolean hasNext();
}
