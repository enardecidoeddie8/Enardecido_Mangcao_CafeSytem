/**
 * Represents a meal menu item with optional upsizing and extra sides.
 * Upsizing adds 20 pesos, while each extra side costs 12 pesos.
 *
 * @author Eddie A. Enardecido
        Darriel Mangcao
 * @version 1.0
 */
public class Meal extends MenuItem {

    private boolean upsized;
    private int extraSides;

    /**
     * Creates a meal with default values.
     */
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    /**
     * Creates a meal using the provided item information and options.
     *
     * @param name the name of the meal
     * @param basePrice the original price of the meal
     * @param itemCode the unique code of the meal
     * @param upsized indicates whether the meal is upsized
     * @param extraSides the number of additional sides
     */
    public Meal(String name, double basePrice, String itemCode,
                boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides);
    }

    /**
     * Calculates the final meal price, including upsizing and extra sides.
     *
     * @return the total price of the meal
     */
    @Override
    public double computePrice() {
        double price = basePrice;

        // Add 20 pesos when the meal is upsized.
        if (upsized) {
            price += 20;
        }

        // Add 12 pesos for every extra side.
        return price + (12 * extraSides);
    }

    /**
     * Returns the meal description with its size and extra sides.
     *
     * @return the complete meal description
     */
    @Override
    public String getDescription() {
        String sizeStatus = upsized ? "Upsized" : "Regular";
        String sideLabel = extraSides == 1 ? "side" : "sides";

        return super.getDescription() + " " + sizeStatus + ", "
                + extraSides + " " + sideLabel;
    }

    /**
     * Checks whether the meal is upsized.
     *
     * @return true if the meal is upsized, otherwise false
     */
    public boolean isUpsized() {
        return upsized;
    }

    /**
     * Changes the upsizing status of the meal.
     *
     * @param upsized the new upsizing status
     */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    /**
     * Gets the number of extra sides.
     *
     * @return the number of additional sides
     */
    public int getExtraSides() {
        return extraSides;
    }

    /**
     * Updates the number of extra sides if the value is valid.
     *
     * @param extraSides the new number of extra sides
     */
    public void setExtraSides(int extraSides) {

        // Reject negative values and preserve the previous valid value.
        if (extraSides < 0) {
            System.out.println("Error: extra sides cannot be negative.");
        } else {
            this.extraSides = extraSides;
        }
    }
}
