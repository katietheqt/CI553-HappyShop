package ci553.happyshop.catalogue;

import ci553.happyshop.catalogue.trolley.Trolley;
import ci553.happyshop.orderManagement.OrderState;

/**
 * The Order class represents a customer order, including metadata and a list of ordered products.
 * <p>
 * Responsibilities:
 * - sotres information about an order, including order ID, current order state, timestamps, and the list of products.
 * - Provides getter methods for order attributes and allows updating the order state.
 * - Formats the full order details for writing to a file, including timestamps and item list.
 * <p>
 * An order file example:
 * Order ID: 10
 * State: Ordered
 * OrderedDateTime: 2025-05-03 16:52:24
 * ProgressingDateTime:
 * CollectedDateTime:
 * Items:
 * 0002    DAB Radio          ( 1) £  29.99
 * 0004    Watch              ( 1) £  29.99
 * 0007    USB drive          ( 1) £   6.99
 * --------------------------------------------
 * Total                               £  66.97
 * <p>
 * This class is mainly used by OrderHub to create and manage order objects during
 * the order lifecycle (ordered → progressing → collected).
 */

public class Order {
    private final int orderId;
    private OrderState state;
    private String orderedDateTime = "";
    private String progressingDateTime = "";
    private String collectedDateTime = "";
    private Trolley trolley; //Trolley

    // Constructor used by OrderHub to create a new order for a customer.
    // Initializes the order with an ID, state, order date/time, and a list of ordered products.
    public Order(int orderId, OrderState state, String orderedDateTime, Trolley trolley) {
        this.orderId = orderId;
        this.state = state;
        this.orderedDateTime = orderedDateTime;
        this.trolley = trolley;
    }

    //a set of getter methods
    public int getOrderId() {
        return orderId;
    }

    public OrderState getState() {
        return state;
    }

    public String getOrderedDateTime() {
        return orderedDateTime;
    }

    public Trolley getTrolley() {
        return trolley;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    /**
     * order details written to file, used by OrderHub
     * - Order metadata (ID, state, and three timestamps)
     * -Product details included in the order
     */
    public String orderDetails() {
        return String.format("""
                        Order ID: %s\s
                        State: %s\s
                        OrderedDateTime: %s\s
                        ProgressingDateTime: %s\s
                        CollectedDateTime: %s
                        Items:
                        %s""",
                orderId,
                state,
                orderedDateTime,
                progressingDateTime,
                collectedDateTime,
                trolley.formatNicely()
        );
    }
}


