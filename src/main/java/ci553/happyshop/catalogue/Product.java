package ci553.happyshop.catalogue;

import java.util.Objects;

/**
 * The Product class used to hold the information about a product:
 * <p>
 * Fields:
 * - productId: Unique identifier for the product (eg 0001).
 * - description: Textual description of the product.
 * - unitPrice: Price per single unit of the product.
 * - orderedQuantity: Quantity involved in a customer's order.
 * - stockQuantity: Quantity currently available in stock.
 * <p>
 * Note: this class has a natural ordering that is inconsistent with equals.
 */
public class Product implements Comparable<Product> {
    private final String proId;
    private final String proDescription;
    private final String proImageName;
    private final double unitPrice;
    private final int stockQuantity;

    /**
     * Constructor,used by DatabaseRW, make product from searching ResultSet
     * @param id Product ID
     * @param des Description of product
     * @param image image name of product, eg 0001.jpg (0001 is product ID)
     * @param aPrice The price of the product
     * @param stockQuantity The Quantity of the product in stock
     */
    public Product(String id, String des, String image, double aPrice, int stockQuantity) {
        proId = id;
        proDescription = des;
        proImageName = image;
        unitPrice = aPrice;
        this.stockQuantity = stockQuantity;
    }

    // a set of getter methods
    public String getProductId() { return proId; }
    public String getProductDescription() { return proDescription; }
    public String getProductImageName() { return proImageName; }
    public double getUnitPrice() { return unitPrice; }
    public int getStockQuantity() { return stockQuantity; }

    @Override
    public int compareTo(Product otherProduct) {
        // Compare by product ID or any other attribute you want to sort by
        return this.proId.compareTo(otherProduct.proId); // Sort by proId alphabetically (ascending);
    }

    @Override
    // Creates a formatted string containing ID, price (with 2 decimal places), stock amount, and description
    // Used in the Warehouse search page to display searched product information
    public String toString() {
        return String.format("Id: %s, £%.2f/uint, stock: %d \n%s",
                          proId, unitPrice,stockQuantity,proDescription);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(unitPrice, product.unitPrice) == 0 && stockQuantity == product.stockQuantity && Objects.equals(proId, product.proId) && Objects.equals(proDescription, product.proDescription) && Objects.equals(proImageName, product.proImageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proId, proDescription, proImageName, unitPrice, stockQuantity);
    }
}

