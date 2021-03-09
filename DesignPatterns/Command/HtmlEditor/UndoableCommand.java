package DesignPatterns.Command.HtmlEditor;

public interface UndoableCommand extends Command {
    void unExecute();
}