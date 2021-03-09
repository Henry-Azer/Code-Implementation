package DesignPatterns.State;

public class SelectionTool implements Tool {
    @Override
    public void mouseDown() {
        System.out.println("SelectionTool icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw dash rectangle");
    }
}
