/**
 * Demonstrates the Campus Cafe ordering system.
 * Creates customers, beverages, pastries, meals, and orders.
 * Tests item pricing, validation, discounts, vouchers, and receipts.
 *
 * @author Eddie A. Enardecido
           Darriel Mangcao
 * @version 1.0
 */
public class CafeApp {

    /**
     * Executes the cafe ordering system and demonstrates its features.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // Create customers with different student statuses.
        Customer customer1 = new Customer("Romer Enardecido", true);
        Customer customer2 = new Customer("Bernard Russel ");

        // Create menu items using parameterized constructors.
        Beverage latte = new Beverage("Iced Latte", 95.00, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45.00, "P-01", true);
        Meal adobo = new Meal("Chicken Adobo", 110.00, "M-01", true, 1);

        // Create a pastry using the default constructor.
        Pastry cookie = new Pastry();
        cookie.setName("Cookie");
        cookie.setBasePrice(30.00);
        cookie.setItemCode("P-02");

        // Create a meal using the default constructor.
        Meal defaultMeal = new Meal();
        defaultMeal.setName("Rice Meal");
        defaultMeal.setBasePrice(100.00);
        defaultMeal.setItemCode("M-03");

        // Create the first order and add its menu items.
        Order order1 = new Order("1001", customer1);
        order1.addItem(latte);
        order1.addItem(ensaymada);
        order1.addItem(adobo);
        order1.addItem(cookie);

        // Test price validation using a negative value.
        latte.setBasePrice(-5);

        // Print the first customer's receipt.
        order1.printReceipt();

        // Create a beverage using the default constructor.
        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");

        // Test negative price validation before assigning a valid price.
        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80.00);
        hotChocolate.setItemCode("B-02");
        hotChocolate.setSize("M");

        // Create another meal using the parameterized constructor.
        Meal beefTapa = new Meal("Beef Tapa", 130.00, "M-02", false, 0);

        // Create the second order and add its menu items.
        Order order2 = new Order("1002", customer2);
        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);

        // Apply a 20-peso voucher to the second order.
        order2.computeTotal(20.00);

        // Print the second customer's receipt.
        order2.printReceipt();
    }
}