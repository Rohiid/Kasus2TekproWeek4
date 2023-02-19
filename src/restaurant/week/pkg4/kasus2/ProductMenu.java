/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.week.pkg4.kasus2;

/**
 *
 * @author victu
 */
public class ProductMenu {
    private Product[] products;

    public ProductMenu() {
        this.products = new Product[10];
    }

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            }
        }
    }

    public Product getProduct(int index) {
        return products[index];
    }

    public void display() {
        System.out.println("\n=== Menu Makanan ===");
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                Product product = products[i];
                System.out.printf("%d. %-14s Rp%,10d [%d]\n", i+1, product.getName(), product.getPrice(), product.getQuantity());
            }
        }
    }
}

