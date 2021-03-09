package DesignPatterns.Command.VideoEditor;

public class SetTextCommand extends AbstractUndoableCommand {
    private final String prevText;
    private final String text;

    public SetTextCommand(History history, VideoEditor editor, String text) {
        super(history, editor);

        prevText = editor.getText();
        this.text = text;
    }

    @Override
    public void undo() {
        editor.setText(prevText);
    }

    @Override
    protected void doExecute() {
        editor.setText(text);
    }
}
