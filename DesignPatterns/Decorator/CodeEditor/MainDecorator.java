package DesignPatterns.Decorator.CodeEditor;

public class MainDecorator implements AbstractArtifact {
    private final AbstractArtifact artifact;

    public MainDecorator(AbstractArtifact artifact) {
        this.artifact = artifact;
    }

    @Override
    public String render() {
        return artifact.render() + " [Main]";
    }
}
