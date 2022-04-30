package DesignPatterns.Visitor.Transaction;

public record WithdrawTransaction(int withdraw) implements Transaction {

    @Override
    public void apply(TransactionType transaction, User user) {
        user.balance = user.balance - withdraw;
        System.out.println("Withdraw Transaction by: " + withdraw);
    }
}
