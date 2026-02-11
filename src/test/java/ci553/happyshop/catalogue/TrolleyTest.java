package ci553.happyshop.catalogue;

import ci553.happyshop.catalogue.trolley.Trolley;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TrolleyTest {
    /**
     * Creates a dummy product for testing.
     *
     * @param number a unique ID for the product.
     * @return A dummy product with some placeholder properties.
     */
    private static Product createDummyProduct(int number) {
        return new Product(
                "dummy-" + number,
                "Dummy Product #" + number,
                "dummy.jpg",
                1.00,
                1000
        );
    }

    @Test
    public void testAddAndRemove() {
        Trolley trolley = new Trolley();
        assertTrue(trolley.getProducts().isEmpty(), "trolley started non-empty");

        Product dummyOne = createDummyProduct(1);
        Product dummyTwo = createDummyProduct(2);

        // make sure basic product addition works
        trolley.add(dummyOne);
        assertEquals(1, trolley.getProducts().size(), "failed to add an item to trolley");

        trolley.add(dummyTwo);
        assertEquals(2, trolley.getProducts().size(), "failed to add a second item to trolley");

        // make sure adding the same product multiple times doesn't add it again
        trolley.add(dummyOne);
        assertEquals(2, trolley.getProducts().size(), "trolley coalescing is broken");

        // make sure removing works properly
        trolley.remove("dummy-1");
        assertEquals(1, trolley.getProducts().size(), "trolley removal is broken");

        // removing twice should throw
        assertThrows(
                NoSuchElementException.class,
                () -> trolley.remove("nonexistent"),
                "trolley doesn't throw on removal of nonexistent element"
        );
    }
}
