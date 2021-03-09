package DesignPatterns.Mediator.ArticleDialogBox;

public class Button extends UIControl {
    private boolean isEnable;

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
        notifyEventHandler();
    }
}
