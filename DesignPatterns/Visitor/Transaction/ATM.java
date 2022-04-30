package DesignPatterns.Visitor.Transaction;

public class ATM {

    private final ATMTransactionManager atmTransaction = new TransactionType();
    public User user;

    public void applyTransaction(Transaction transaction) {
        atmTransaction.applyTransaction(transaction, user);
    }
}
