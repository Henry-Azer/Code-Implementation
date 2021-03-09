package DesignPatterns.Template.AuditTrial;

public class GenerateReportTask extends Task {
    @Override
    public void doExecute() {
        System.out.println("Generate Report");
    }
}
