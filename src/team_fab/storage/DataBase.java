package team_fab.storage;

import java.util.ArrayList;
import java.util.List;

import team_fab.objects.Meat;
import team_fab.objects.Potato;
import team_fab.objects.Product;
import team_fab.objects.Rice;

public class DataBase {

    private Product[] products;
    private List<Product> sales;
    private List<Product> purchases;

    public DataBase() {
        products = new Product[3];
        Product potato = new Potato("Sabanera");
        Product rice = new Rice("Calidad");
        Product meat = new Meat("Lomo fino");

        products[0] = potato;
        products[1] = rice;
        products[2] = meat;

        purchases = new ArrayList<>();
        sales = new ArrayList<>();
    }

    // Obtiene el producto por el ID
    public Product getByIndex(int i) {
        if (i < 0 || i > 2) {
            System.out.println("Ese item no existe");
            return null;
        }

        Product result = null;
        try {
            result =(Product) products[i].clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Devuelve todos los productos
    public Product[] getAll() {
        Product[] result = new Product[3];
        try {
            result[0] = (Product) products[0].clone();
            result[1] = (Product) products[1].clone();
            result[2] = (Product) products[2].clone();
        } catch (CloneNotSupportedException ignored) {
        }

        return result;
    }

    public void buyProduct(Product p) {
        Product oldProduct;
        switch (p.getClass().getSimpleName()) {
            case "Potato":
                oldProduct = products[0];
                break;
            case "Rice":
                oldProduct = products[1];
                break;
            case "Meat":
                oldProduct = products[2];
                break;
            default:
                System.out.println("El producto no es válido");
                return;
        }

        oldProduct.setAmount(oldProduct.getAmount() + p.getAmount());
        oldProduct.setPrice(p.getPrice());
    }

    public void saleProduct(Product p, int amount) {
        Product oldProduct;
        switch (p.getClass().getSimpleName()) {
            case "Potato":
                oldProduct = products[0];
                break;
            case "Rice":
                oldProduct = products[1];
                break;
            case "Meat":
                oldProduct = products[2];
                break;
            default:
                System.out.println("El producto no es válido");
                return;
        }

        oldProduct.setAmount(oldProduct.getAmount() - amount);
    }

    // Agrega ventas
    public void addSale(Product p) {
        sales.add(p);
    }

    // Devuelve todos los productos vendidos
    public List<Product> getSales() {
        return sales;
    }

    // Agrega compras
    public void addPurchase(Product p) {
        purchases.add(p);
    }

    // Devuelve todos los productos comprados
    public List<Product> getPurchases() {
        return purchases;
    }
}
