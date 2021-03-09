package DesignPatterns.Decorator.CodeEditor;

public class ErrorDecorator implements AbstractArtifact {
    private final AbstractArtifact artifact;

    public ErrorDecorator(AbstractArtifact artifact) {
        this.artifact = artifact;
    }

    @Override
    public String render() {
        var mainIcon = artifact.render();
        return mainIcon + " [Error]";
    }
}
