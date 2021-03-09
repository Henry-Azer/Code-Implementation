package DesignPatterns.Command.HtmlEditor;

public class BoldCommand implements UndoableCommand {
    private final HtmlDocument document;
    private final History history;
    private String prevContent;

    public BoldCommand(HtmlDocument htmlDocument, History history) {
        this.document = htmlDocument;
        this.history = history;
    }

    @Override
    public void unExecute() {
        document.setContent(prevContent);
    }

    @Override
    public void execute() {
        prevContent = document.getContent();
        document.makeBold();
        history.push(this);
    }
}
