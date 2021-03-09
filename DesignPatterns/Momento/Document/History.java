package DesignPatterns.Momento.Document;

import java.util.Stack;

public class History {

    private final Stack<DocumentState> states = new Stack<>();

    public void push(DocumentState documentState) {
        states.push(documentState);
    }

    public DocumentState pop() {
        if (states.size() > 1)
            states.remove(states.lastElement());

        return states.lastElement();
    }
}
