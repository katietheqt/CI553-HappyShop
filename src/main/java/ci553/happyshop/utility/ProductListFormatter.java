package ci553.happyshop.utility;

import ci553.happyshop.catalogue.trolley.Trolley;

/**
 * This class builds a formatted, receipt-like summary from a list of products.
 * It is used by:
 * 1. CustomerModel – to display the trolley and receipt
 * 2. The Order class – to generate a summary for writing to an order's file
 *
 * @deprecated Method moved to {@link Trolley}.
 */
@Deprecated
public class ProductListFormatter {
    /**
     * Builds a formatted string showing each product's ID, description,
     * quantity ordered, and total price. Also includes a total price at the end.
     * @param trolley the trolley to format
     * @return A nicely formatted string representation of the product list with totals
     * @deprecated Use {@link Trolley#formatNicely()}
     */
    @Deprecated
    public static String buildString(Trolley trolley) {
        return trolley.formatNicely();
    }
}
