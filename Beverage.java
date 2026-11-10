/**
 * Represents a beverage menu item with different size options.
 * The price changes depending on the selected beverage size.
 *
 * @author Eddie A. Enardecido
           Darriel Mangcao
 * @version 1.0
 */
public class Beverage extends MenuItem {

    private String size;

    /**
     * Creates a beverage with default values.
     */
    public Beverage() {
        super();
        size = "S";
    }

    /**
     * Creates a beverage using the given item information and size.
     *
     * @param name the name of the beverage
     * @param basePrice the original price of the beverage
     * @param itemCode the unique code of the beverage
     * @param size the selected beverage size
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }

    /**
     * Calculates the final price based on the beverage size.
     *
     * @return the calculated beverage price
     */
    @Override
    public double computePrice() {

        // Large beverages receive an additional 25 pesos.
        if (size.equals("L")) {
            return basePrice + 25;

        // Medium beverages receive an additional 15 pesos.
        } else if (size.equals("M")) {
            return basePrice + 15;

        // Small beverages retain their original base price.
        } else {
            return basePrice;
        }
    }

    /**
     * Returns the beverage description together with its size.
     *
     * @return the complete beverage description
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /**
     * Gets the current beverage size.
     *
     * @return the selected beverage size
     */
    public String getSize() {
        return size;
    }

    /**
     * Changes the beverage size if the supplied value is valid.
     *
     * @param size the new beverage size (S, M, or L)
     */
    public void setSize(String size) {

        // Accept only small, medium, or large sizes.
        if ("S".equals(size) || "M".equals(size) || "L".equals(size)) {
            this.size = size;
        }
    }
}
