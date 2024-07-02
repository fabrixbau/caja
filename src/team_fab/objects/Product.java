package team_fab.objects;

public abstract class Product implements Cloneable {
    private String name;
    private int amount;
    private double price;

    public Product() {
    }

    public Product(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0) {
            System.out.println("cannot assign a negative quantity");
            return;
        }
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("you can't set a negative price");
            return;
        }
        this.price = price;
    }

    @Override
    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }
}
