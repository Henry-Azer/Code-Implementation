package DesignPatterns.Decorator.CodeEditor;

public class Editor {
    public void openProject(String path) {
        AbstractArtifact[] artifacts = {
                new Artifact("Main"),
                new Artifact("Demo"),
                new Artifact("EmailClient"),
                new Artifact("EmailProvider"),
        };

        artifacts[0] = new ErrorDecorator(new MainDecorator(artifacts[0]));
        artifacts[2] = new ErrorDecorator(artifacts[2]);

        for (var artifact : artifacts)
            System.out.println(artifact.render());
    }
}
