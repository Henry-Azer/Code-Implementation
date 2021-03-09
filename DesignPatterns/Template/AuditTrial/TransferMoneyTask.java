package DesignPatterns.Template.AuditTrial;

public class TransferMoneyTask extends Task {
    @Override
    public void doExecute() {
        System.out.println("Transfer Money");
    }
}
