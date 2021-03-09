package DesignPatterns.Mediator.SignUpBox;

import java.util.ArrayList;
import java.util.List;

public abstract class UIControl {
    private final List<EventHandler> handlerList = new ArrayList<>();

    public void addEventHandler(EventHandler eventHandler) {
        handlerList.add(eventHandler);
    }

    protected void notifyEventHandler() {
        for (var event: handlerList)
            event.handel();
    }
}
