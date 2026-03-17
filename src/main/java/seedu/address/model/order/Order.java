package seedu.address.model.order;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;

/**
 * Represents an Order in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Order {

    private static int orderIdx = 0;
    private final OrderId orderId;
    private final Person person;
    // private final Product product;
    // private final Quantity quantity;
    // private final Price price;
    private final Map<Integer, Integer> orders;
    private final OrderStatus status;
    private final OrderDateTime orderDatetime;

    /**
     * Every field must be present and not null.
     */
    public Order(Person person, Map<Integer, Integer> orders) {
        requireAllNonNull(person, orders);
        this.orderId = new OrderId(Integer.toString(orderIdx));
        this.person = person;
        // this.product = product;
        // this.quantity = quantity;
        // this.price = price;
        this.orders = orders;
        this.status = OrderStatus.PENDING;
        this.orderDatetime = new OrderDateTime(LocalDateTime.now());
        orderIdx ++;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public Person getPerson() {
        return person;
    }

    /** public Product getProduct() {
        return product;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Price getPrice() {
        return price;
    } **/

    public Map<Integer, Integer> getOrders() {
        return orders;
    }

    public OrderStatus getOrderStatus() {
        return status;
    }

    public OrderDateTime getDate() {
        return orderDatetime;
    }

    /**
     * Returns true if both orders have the same name.
     * This defines a weaker notion of equality between two orders.
     */
    public boolean isSameOrder(Order otherOrder) {
        if (otherOrder == this) {
            return true;
        }

        return otherOrder != null
                && otherOrder.getOrderId().equals(getOrderId());
    }

    /**
     * Returns true if both orders have the same identity and data fields.
     * This defines a stronger notion of equality between two orders.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Order)) {
            return false;
        }

        Order otherOrder = (Order) other;
        return orderId.equals(otherOrder.orderId);
//                && product.equals(otherOrder.product)
//                && quantity.equals(otherOrder.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId); //, product, quantity);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("orderId", orderId)
                .add("person", person)
/**
                .add("product", product)
                .add("quantity", quantity)
                .add("price", price)
 **/
                .add("status", status)
                .add("orderDatetime", orderDatetime)
                .toString();
    }
}
