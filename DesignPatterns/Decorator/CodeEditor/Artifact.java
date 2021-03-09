package DesignPatterns.Decorator.CodeEditor;

public class Artifact implements AbstractArtifact {
    private final String name;

    public Artifact(String name) {
        this.name = name;
    }

    public String render() {
        return name;
    }

}
