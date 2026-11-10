/**
 * Represents a pastry menu item that can be served warmed or not warmed.
 * A warmed pastry has an additional charge of 10 pesos.
 *
 * @author Eddie A. Enardecido
           Darriel Mangcao
 * @version 1.0
 */
public class Pastry extends MenuItem {

    private boolean warmed;

    /**
     * Creates a pastry with default values.
     */
    public Pastry() {
        super();
        warmed = false;
    }

    /**
     * Creates a pastry using the provided item information.
     *
     * @param name the name of the pastry
     * @param basePrice the original price of the pastry
     * @param itemCode the unique code of the pastry
     * @param warmed indicates whether the pastry is warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Calculates the final price of the pastry.
     *
     * @return the pastry price, including the warming charge if applicable
     */
    @Override
    public double computePrice() {

        // Add 10 pesos when the pastry is warmed.
        if (warmed) {
            return basePrice + 10;
        }

        // Return the original price when the pastry is not warmed.
        return basePrice;
    }

    /**
     * Returns the pastry description with its warming status.
     *
     * @return the pastry description
     */
    @Override
    public String getDescription() {

        // Add the warmed label when the pastry is warmed.
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }

        // Return the regular description otherwise.
        return super.getDescription();
    }

    /**
     * Checks whether the pastry is warmed.
     *
     * @return true if the pastry is warmed, otherwise false
     */
    public boolean isWarmed() {
        return warmed;
    }

    /**
     * Changes the warming status of the pastry.
     *
     * @param warmed the new warming status
     */
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}