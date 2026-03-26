package seedu.address.model.order;

import java.util.Optional;

/**
 * Represents a product + quantity pair.
 */
public class ProductQuantityPair {
    public static final String MESSAGE_CONSTRAINTS =
            "Orders should be in the form \"MENU_ITEM PRODUCT_QUANTITY\".";
    public static final String VALIDATION_REGEX = "^[1-9]\\d* \\d+$";
    private final Product product;
    private final Quantity quantity;

    /**
     * Constructs a {@code ProductQuantityPair}.
     *
     * @param productQuantityPair A valid product + quantity pair.
     */
    public ProductQuantityPair(String productQuantityPair) {
        String[] pair = productQuantityPair.split(" ", 2);
        String product = pair[0];
        String quantity = pair[1];
        this.product = new ProductList().getItem(Integer.parseInt(product));
        if (Quantity.isValidQuantity(quantity)) {
            this.quantity = new Quantity(quantity);
        } else {
            throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
    }

    /**
     * Returns true if a given string is a valid product + quantity pair.
     */
    public static boolean isValidProductQuantityPair(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns the Product of a ProductQuantityPair.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns the Quantity of a ProductQuantityPair.
     */
    public Optional<Quantity> getQuantity() {
        return Optional.ofNullable(quantity);
    }
}
