/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.week.pkg4.kasus2;

/**
 *
 * @author victu
 */
    import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // create menu
        ProductMenu menu = new ProductMenu();
        menu.addProduct(new Product("Kebab", 20_000, 10));
        menu.addProduct(new Product("Burger", 30_000, 10));
        menu.addProduct(new Product("Hotdog", 18_000, 0));
        menu.addProduct(new Product("French Fries", 10_000, 10));
        menu.addProduct(new Product("Fried Chicken", 12_000, 10));
        menu.addProduct(new Product("Salad", 15_000, 10));
        menu.addProduct(new Product("Chicken Nugget", 20_000, 10));
        menu.addProduct(new Product("Rice Small", 5_000, 10));
        menu.addProduct(new Product("Rice Medium", 6_000, 10));
        menu.addProduct(new Product("Rice Large", 7_000, 10));
            // create sales
    Sales sales = new Sales();

    boolean isOrdering = true;
    while (isOrdering) {
        System.out.println("\n=== Selamat Datang di Sandchik Restaurant ===");
        menu.display();

        System.out.print("\nMasukkan nomor produk yang ingin dipesan: ");
        int productIdx = scan.nextInt() - 1; // minus 1 to adjust for zero-based index
        Product selectedProduct = menu.getProduct(productIdx);

        System.out.print("Masukkan jumlah pesanan: ");
        int quantity = scan.nextInt();

        if (selectedProduct.getQuantity() < quantity) {
            System.out.println("Maaf, stok " + selectedProduct.getName() + " tidak cukup.");
        } else {
            // add the selected product and quantity to the sales
            sales.addProduct(selectedProduct, quantity);

            // update the product quantity in the menu
            selectedProduct.reduceQuantity(quantity);

            System.out.print("\nPesanan berhasil ditambahkan. Ingin memesan item makanan lain? (y/n) ");
            String choice = scan.next();
            if (!choice.equalsIgnoreCase("y")) {
                isOrdering = false;
            }
        }
    }

    // display the sales and total amount
    System.out.println("\n=== Daftar Pesanan ===");
    sales.display();
    System.out.printf("\nTotal Bayar: Rp%,d", sales.getTotalAmount());

    scan.close();
}
}


