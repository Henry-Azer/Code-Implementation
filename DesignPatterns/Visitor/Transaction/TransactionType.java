package DesignPatterns.Visitor.Transaction;

public class TransactionType extends ATMTransactionManager {
    @Override
    public void applyTransaction(Transaction transaction, User user) {
        transaction.apply(this, user);
    }
}
