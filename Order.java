/**
 * Represents a customer order containing up to three menu items.
 * Calculates subtotals, student discounts, voucher deductions,
 * and loyalty points while providing a printed receipt.
 *
 * @author Eddie A. Enardecido
           Darriel Mangcao
 * @version 1.0
 */
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;
    private double appliedVoucher;

    /**
     * Creates an order for a specific customer.
     *
     * @param orderId the unique identification number of the order
     * @param customer the customer who placed the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        item1 = null;
        item2 = null;
        item3 = null;
        itemCount = 0;
        appliedVoucher = 0.0;
    }

    /**
     * Adds a menu item to the order if a slot is available.
     *
     * @param item the menu item to add
     * @return true if the item was successfully added, otherwise false
     */
    public boolean addItem(MenuItem item) {

        // Reject null menu items.
        if (item == null) {
            System.out.println("Invalid menu item.");
            return false;

        // Place the item in the first available slot.
        } else if (item1 == null) {
            item1 = item;
            itemCount++;
            return true;

        } else if (item2 == null) {
            item2 = item;
            itemCount++;
            return true;

        } else if (item3 == null) {
            item3 = item;
            itemCount++;
            return true;

        // Reject additional items when all three slots are occupied.
        } else {
            System.out.println("Order is full. Cannot add "
                    + item.getName() + ".");
            return false;
        }
    }

    /**
     * Calculates the sum of all menu item prices.
     *
     * @return the order subtotal before discounts and vouchers
     */
    public double computeSubtotal() {
        double subtotal = 0.0;

        // Each object uses its own overridden computePrice method.
        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    /**
     * Calculates the order total after applying a student discount.
     *
     * @return the final price after the applicable student discount
     */
    public double computeTotal() {
        appliedVoucher = 0.0;
        double subtotal = computeSubtotal();

        // Students receive a 10 percent discount.
        if (customer.isStudent()) {
            return subtotal - (subtotal * 0.10);
        } else {
            return subtotal;
        }
    }

    /**
     * Calculates the order total after applying a voucher deduction.
     * The voucher cannot reduce the total below zero.
     *
     * @param voucher the voucher amount to deduct from the order
     * @return the final order total after discounts and voucher deduction
     */
    public double computeTotal(double voucher) {
        double total = computeTotal();

        // Negative voucher values are not accepted.
        if (voucher < 0) {
            appliedVoucher = 0.0;
        } else {
            appliedVoucher = voucher;
        }

        total -= appliedVoucher;

        // Prevent the final order total from becoming negative.
        if (total < 0) {
            total = 0.0;
        }

        return total;
    }

    /**
     * Prints the order receipt, including item prices, discounts,
     * voucher deductions, final payment, and customer loyalty points.
     */
    public void printReceipt() {
        double subtotal = computeSubtotal();
        double discount = customer.isStudent() ? subtotal * 0.10 : 0.0;
        double total = subtotal - discount - appliedVoucher;

        // Prevent the receipt total from becoming negative.
        if (total < 0) {
            total = 0.0;
        }

        String studentLabel = customer.isStudent() ? " (Student)" : "";

        System.out.println("\\nOrder #" + orderId + " — "
                + customer.getName() + studentLabel);

        printItem(item1);
        printItem(item2);
        printItem(item3);

        System.out.printf("Subtotal: %.2f%n", subtotal);

        // Display the student discount when applicable.
        if (customer.isStudent()) {
            System.out.printf("Student discount (10%%): -%.2f%n", discount);
        }

        // Display the voucher deduction when applied.
        if (appliedVoucher > 0) {
            System.out.printf("Voucher: -%.2f%n", appliedVoucher);
        }

        System.out.printf("TOTAL: %.2f%n", total);

        // Award loyalty points based on the final amount paid.
        customer.addPoints(total);

        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
    }

    /**
     * Displays the description and price of a menu item.
     * Only prints the item when it is not null.
     *
     * @param item the menu item to display
     */
    private void printItem(MenuItem item) {

        // Display the item only if a valid object exists.
        if (item != null) {
            System.out.printf("%-43s %.2f%n",
                    item.getDescription(), item.computePrice());
        }
    }
}