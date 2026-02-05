package ci553.happyshop.catalogue.trolley;

import ci553.happyshop.catalogue.Product;

import java.util.*;

/**
 * Wrapper for the trolley. Stores a sorted list of {@link TrolleyProduct}s.
 */
public class Trolley {
    private final List<TrolleyProduct> products = new ArrayList<>();

    /**
     * Adds 1 of a product into the trolley. Will increment the trolley quantity if the product is already present.
     *
     * @param product the product to add
     */
    public void add(Product product) {
        // try and find the product in the list
        for (TrolleyProduct existingTrolleyProduct : products) {
            Product existingProduct = existingTrolleyProduct.getProduct();

            if (existingProduct.getProductId().equals(product.getProductId())) {
                // found it
                int quantity = existingTrolleyProduct.getTrolleyQuantity();
                existingTrolleyProduct.setTrolleyQuantity(quantity + 1);

                return;
            }
        }

        // it's not present, add it and then sort by ID.
        products.add(new TrolleyProduct(product));
        products.sort(Comparator.comparing(TrolleyProduct::getProduct));
    }

    /**
     * Removes all of a product from the trolley (by ID).
     *
     * @param productId the ID of the product to remove
     */
    public void remove(String productId) {
        products.removeIf(product -> product.getProduct().getProductId().equals(productId));
    }

    /**
     * Empties the trolley.
     */
    public void clear() {
        products.clear();
    }

    /**
     * @return whether the trolley is empty.
     */
    public boolean isEmpty() {
        return products.isEmpty();
    }

    /**
     * @return an immutable view of products in the trolley.
     */
    public List<TrolleyProduct> getProducts() {
        return Collections.unmodifiableList(products);
    }

    /**
     * Builds a formatted string showing each product's ID, description, quantity ordered, and total price. Also
     * includes a total price at the end.
     *
     * @return a nicely formatted representation of this trolley.
     */
    public String formatNicely() {
        StringBuilder sb = new StringBuilder();
        double totalPrice = 0;
        for (TrolleyProduct tp : products) {
            int orderedQuantity = tp.getTrolleyQuantity();
            Product pr = tp.getProduct();

            //%-18.18s, format the argument as a String,
            // -18 → Left-align the string in 18-character wide space.
            //.18 → Truncate the string to at most 18 characters
            String aProduct = String.format(" %-7s %-18.18s (%2d) £%7.2f\n",
                    pr.getProductId(),
                    pr.getProductDescription(),
                    orderedQuantity,
                    pr.getUnitPrice() * orderedQuantity);

            sb.append(aProduct);
            totalPrice = totalPrice + pr.getUnitPrice() * orderedQuantity;
        }

        String lineSeparator = "-".repeat(44) + "\n";
        String total = String.format(" %-35s £%7.2f\n", "Total", totalPrice);

        sb.append(lineSeparator);
        sb.append(total);
        return sb.toString();
    }
}
