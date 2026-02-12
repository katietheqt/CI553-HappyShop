package ci553.happyshop.catalogue;

import ci553.happyshop.catalogue.trolley.Trolley;
import ci553.happyshop.orderManagement.OrderHub;
import ci553.happyshop.orderManagement.OrderState;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderHubTest {
    @Test
    public void testNewOrder() throws SQLException, IOException {
        Product dummyProduct = TestUtilities.createDummyProduct(1);

        OrderHub hub = new OrderHub();

        Trolley trolley = new Trolley();
        trolley.add(dummyProduct);

        Order order = hub.newOrder(trolley);

        assertEquals(trolley, order.getTrolley(), "order trolley doesn't match");
        assertEquals(OrderState.Ordered, order.getState(), "unexpected order state");
    }
}
