package biz;

public class Supplier extends Account {
    protected String name;
    private String address;
    private ProductCatalog productCatalog;

    public Supplier() {
        this.productCatalog = new ProductCatalog();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }
}
