package DesignPatterns.Observer.Stock;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private final List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObservers() {
        for (var observer: observerList)
            observer.priceChanged();
    }
}
