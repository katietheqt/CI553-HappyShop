package ci553.happyshop.catalogue;

public class TestUtilities {
    private TestUtilities() {
        throw new UnsupportedOperationException("Cannot instantiate TestUtilities");
    }

    /**
     * Creates a dummy product for testing.
     *
     * @param number a unique ID for the product.
     * @return A dummy product with some placeholder properties.
     */
    public static Product createDummyProduct(int number) {
        return new Product(
                "dummy-" + number,
                "Dummy Product #" + number,
                "dummy.jpg",
                1.00,
                1000
        );
    }
}
