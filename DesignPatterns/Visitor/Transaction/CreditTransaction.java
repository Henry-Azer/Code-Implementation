package DesignPatterns.Visitor.Transaction;

public record CreditTransaction(int credit) implements Transaction {

    @Override
    public void apply(TransactionType transaction, User user) {
        user.balance = user.balance + credit;
        System.out.println("Credit Transaction by: " + credit);
    }
}
