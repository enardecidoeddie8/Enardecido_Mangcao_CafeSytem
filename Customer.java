/**
 * Represents a customer who can earn loyalty points through purchases.
 * Stores the customer's name, student status, and accumulated points.
 *
 * @author Eddie A. Enardecido
           Darriel Mangcao
 * @version 1.0
 */
public class Customer {

    private String name;
    private boolean student;
    private int loyaltyPoints;

    /**
     * Creates a customer with default information.
     */
    public Customer() {
        this("Unknown Customer", false);
    }

    /**
     * Creates a customer using the provided name.
     *
     * @param name the customer's name
     */
    public Customer(String name) {
        this(name, false);
    }

    /**
     * Creates a customer with a name and student status.
     *
     * @param name the customer's name
     * @param student indicates whether the customer is a student
     */
    public Customer(String name, boolean student) {
        setName(name);
        this.student = student;
        loyaltyPoints = 0;
    }

    /**
     * Adds loyalty points directly to the customer's account.
     *
     * @param points the number of points to add
     */
    public void addPoints(int points) {

        // Add points only when the supplied value is positive.
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    /**
     * Calculates loyalty points based on the amount spent.
     * Every 50 pesos spent earns one loyalty point.
     *
     * @param amountSpent the total amount spent by the customer
     */
    public void addPoints(double amountSpent) {

        // Award points only for positive purchases.
        if (amountSpent > 0) {
            loyaltyPoints += (int) (amountSpent / 50);
        }
    }

    /**
     * Gets the customer's name.
     *
     * @return the customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the customer's name if the provided value is valid.
     *
     * @param name the new customer name
     */
    public void setName(String name) {

        // Reject null or empty names.
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    /**
     * Checks whether the customer is a student.
     *
     * @return true if the customer is a student, otherwise false
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * Updates the customer's student status.
     *
     * @param student the new student status
     */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /**
     * Gets the customer's accumulated loyalty points.
     *
     * @return the total loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Updates the customer's loyalty points if the value is valid.
     *
     * @param loyaltyPoints the new loyalty point balance
     */
    public void setLoyaltyPoints(int loyaltyPoints) {

        // Prevent the loyalty point balance from becoming negative.
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        }
    }
}