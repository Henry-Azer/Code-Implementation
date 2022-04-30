package DesignPatterns.Visitor.Transaction;

public interface Transaction {
    void apply(TransactionType transaction, User user);
}
