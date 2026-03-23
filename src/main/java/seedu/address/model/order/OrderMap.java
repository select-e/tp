package seedu.address.model.order;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;

public class OrderMap {
    private static int idx = 1;
    private final int orderId;
    private final Person person;
    private final Map<Integer, Integer> orderMap;
    private final OrderStatus status;
    private final OrderDateTime orderDatetime;

    public OrderMap(Person person, Map<Integer, Integer> orderMap) {
        this.orderId = idx;
        this.person = person;
        this.orderMap = orderMap;
        idx ++;
        this.status = OrderStatus.PENDING;
        this.orderDatetime = new OrderDateTime(LocalDateTime.now());
    }

    public Person getPerson() { return person; }

    public int getOrderId() {
        return orderId;
    }

    public Map<Integer, Integer> getOrderMap() {
        return orderMap;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public OrderDateTime getOrderDatetime() {
        return orderDatetime;
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

        if (!(other instanceof OrderMap)) {
            return false;
        }

        OrderMap otherOrder = (OrderMap) other;
        return orderId == otherOrder.getOrderId()
                && orderMap.equals(otherOrder.getOrderMap())
                && person.equals(otherOrder.getPerson())
                && orderDatetime.equals(otherOrder.getOrderDatetime())
                && status.equals(otherOrder.getStatus());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("orderId", orderId)
                .add("person", person)
                .add("status", status)
                .add("orderDatetime", orderDatetime)
                .add("orderMap", orderMap.toString())
                .toString();
    }
}
