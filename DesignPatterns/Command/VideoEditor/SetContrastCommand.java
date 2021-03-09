package DesignPatterns.Command.VideoEditor;

public class SetContrastCommand extends AbstractUndoableCommand {
    private final float contrast;
    private final float prevContrast;

    public SetContrastCommand(History history, VideoEditor editor, float contrast) {
        super(history, editor);

        prevContrast = editor.getContrast();
        this.contrast = contrast;
    }

    @Override
    protected void doExecute() {
        editor.setContrast(contrast);
    }

    @Override
    public void undo() {
        editor.setContrast(prevContrast);
    }
}
