import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void updateQuantity(int newQuantity) {
        quantity = newQuantity;
    }

    public void updatePrice(double newPrice) {
        price = newPrice;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Quantity: " + quantity + ", Price: $" + price;
    }
}

public class InventoryManagementSystem {
    private ArrayList<Product> products;

    public InventoryManagementSystem() {
        products = new ArrayList<>();
    }

    public void addProduct(String name, int quantity, double price) {
        Product product = new Product(name, quantity, price);
        products.add(product);
        System.out.println("Product added successfully.");
    }

    public void updateProductQuantity(String name, int newQuantity) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                product.updateQuantity(newQuantity);
                System.out.println("Quantity updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void updateProductPrice(String name, double newPrice) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                product.updatePrice(newPrice);
                System.out.println("Price updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void viewProductDetails(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void listAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in the inventory.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Quantity");
            System.out.println("3. Update Product Price");
            System.out.println("4. View Product Details");
            System.out.println("5. List All Products");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: $");
                    double price = scanner.nextDouble();
                    ims.addProduct(name, quantity, price);
                    break;
                case 2:
                    System.out.print("Enter product name to update quantity: ");
                    String nameToUpdateQuantity = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    ims.updateProductQuantity(nameToUpdateQuantity, newQuantity);
                    break;
                case 3:
                    System.out.print("Enter product name to update price: ");
                    String nameToUpdatePrice = scanner.nextLine();
                    System.out.print("Enter new price: $");
                    double newPrice = scanner.nextDouble();
                    ims.updateProductPrice(nameToUpdatePrice, newPrice);
                    break;
                case 4:
                    System.out.print("Enter product name to view details: ");
                    String nameToView = scanner.nextLine();
                    ims.viewProductDetails(nameToView);
                    break;
                case 5:
                    ims.listAllProducts();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
