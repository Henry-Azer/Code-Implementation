package DesignPatterns.Mediator.ArticleDialogBox;

public class ArticlesDialogBox {
    private final ListBox articlesListBox = new ListBox();
    private final TextBox titleTextBox = new TextBox();
    private final Button saveButton = new Button();

    public ArticlesDialogBox() {
        articlesListBox.addEventHandler(this::articleSelected);
        titleTextBox.addEventHandler(this::titleChanged);
    }

    public void simulateUserInteraction() {
        articlesListBox.setSelection("Article 1");
        titleTextBox.setContent("");
        System.out.println("Text Box : " + titleTextBox.getContent());
        System.out.println("Button : " + saveButton.isEnable());
    }

    private void titleChanged() {
        var content = titleTextBox.getContent();
        var isEmpty = (content == null || content.isEmpty());
        saveButton.setEnable(!isEmpty);
    }

    private void articleSelected() {
        titleTextBox.setContent(articlesListBox.getSelection());
        saveButton.setEnable(true);
    }
}
