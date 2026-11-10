/**
 * Represents the general structure of a menu item.
 * Stores the item's name, base price, and item code.
 * Subclasses must provide their own price calculation.
 *
 * @author Eddie A. Enardecido
             Darriel Mangcao
 * @version 1.0
 */
public abstract class MenuItem {

    protected String name;
    protected double basePrice;
    private String itemCode;

    /**
     * Creates a menu item with default values.
     */
    public MenuItem() {
        name = "Unnamed Item";
        basePrice = 0.0;
        itemCode = "N/A";
    }

    /**
     * Creates a menu item using the provided information.
     *
     * @param name the name of the menu item
     * @param basePrice the original price of the item
     * @param itemCode the unique code assigned to the item
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this();
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
    }

    /**
     * Calculates the final price of the menu item.
     * Subclasses must implement this method.
     *
     * @return the calculated price of the menu item
     */
    public abstract double computePrice();

    /**
     * Creates a description containing the item's name and code.
     *
     * @return the menu item's description
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
     * Gets the name of the menu item.
     *
     * @return the menu item's name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the name if the provided value is valid.
     *
     * @param name the new name of the menu item
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    /**
     * Gets the original price of the menu item.
     *
     * @return the menu item's base price
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Updates the base price if it is not negative.
     *
     * @param basePrice the new base price
     */
    public void setBasePrice(double basePrice) {

        // Reject negative prices and preserve the previous valid value.
        if (basePrice < 0) {
            System.out.println("Error: base price cannot be negative.");
        } else {
            this.basePrice = basePrice;
        }
    }

    /**
     * Gets the unique code of the menu item.
     *
     * @return the item's code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Updates the item code if the provided value is valid.
     *
     * @param itemCode the new item code
     */
    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode;
        }
    }
}
