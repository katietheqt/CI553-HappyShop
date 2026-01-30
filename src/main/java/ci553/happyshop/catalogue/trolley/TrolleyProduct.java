package ci553.happyshop.catalogue.trolley;

import ci553.happyshop.catalogue.Product;

/**
 * A product that is stored within a {@link Trolley}. Contains a trolley quantity.
 * <p>
 * This class uses composition instead of inheritance, to make it easier to insert a product from the database into the
 * trolley.
 */
public class TrolleyProduct {
    /**
     * The product.
     */
    private final Product product;

    /**
     * The amount of the product in the trolley.
     */
    private int trolleyQuantity = 1;

    public TrolleyProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getTrolleyQuantity() {
        return trolleyQuantity;
    }

    public void setTrolleyQuantity(int trolleyQuantity) {
        this.trolleyQuantity = trolleyQuantity;
    }
}
