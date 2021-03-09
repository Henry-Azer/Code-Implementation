package DesignPatterns.Template.AuditTrial;

public abstract class Task {
    private final AuditTrial auditTrial;

    public Task() {
        this.auditTrial = new AuditTrial();
    }

    public Task(AuditTrial auditTrial) {
        this.auditTrial = auditTrial;
    }

    public void execute() {
        auditTrial.record();
        doExecute();
    }

    protected abstract void doExecute();
}
