package DesignPatterns.Proxy.ORM;

public class ProductProxy extends Product {
    private final DbContext dbContext;

    public ProductProxy(int id, DbContext dbContext) {
        super(id);
        this.dbContext = dbContext;
    }

    @Override
    public void setName(String name) {
        super.setName(name);

        dbContext.markAsChanged(this);
    }
}
