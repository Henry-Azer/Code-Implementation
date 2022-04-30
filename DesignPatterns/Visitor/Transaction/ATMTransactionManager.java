package DesignPatterns.Visitor.Transaction;

public abstract class ATMTransactionManager {

    public abstract void applyTransaction(Transaction transaction, User user);

}
