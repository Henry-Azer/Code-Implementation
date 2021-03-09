package DesignPatterns.Mediator.ArticleDialogBox;

public class ListBox extends UIControl {
    private String selection;

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
        notifyEventHandler();
    }
}
