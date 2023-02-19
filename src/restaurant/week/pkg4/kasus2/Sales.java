/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.week.pkg4.kasus2;

/**
 *
 * @author victu
 */
public class Sales {
    private Product[] products;
    private int[] quantities;

    public Sales() {
        this.products = new Product[10];
        this.quantities = new int[10];
    }

    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                quantities[i] = quantity;
                break;
            }
        }
    }

    public void display() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                Product product = products[i];
                int quantity = quantities[i];
                int total = product.getPrice() * quantity;
                System.out.printf("%d. %-14s x %2d Rp%,10d\n", i+1, product.getName(), quantity, total);
            }
        }
    }

    public int getTotalAmount() {
        int total = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                Product product = products[i];
                int quantity = quantities[i];
                total += product.getPrice() * quantity;
            }
        }
        return total;
    }
}

