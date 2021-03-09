package DesignPatterns.Command.VideoEditor;

public abstract class AbstractUndoableCommand implements UndoableCommand {
    protected final History history;
    protected final VideoEditor editor;

    public AbstractUndoableCommand(History history, VideoEditor editor) {
        this.history = history;
        this.editor = editor;
    }

    @Override
    public void execute() {
        doExecute();
        history.push(this);
    }

    protected abstract void doExecute();
}
