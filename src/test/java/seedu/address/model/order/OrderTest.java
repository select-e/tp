package seedu.address.model.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.OrderBuilder;
import seedu.address.testutil.PersonBuilder;

public class OrderTest {

    private final Person person = new PersonBuilder().build();
    private final Map<Integer, Integer> ordermap = new HashMap<>(1, 2);

    @Test
    void constructor_andGetters_success() {
        Order order = new Order(person, ordermap);
        assertEquals(person, order.getPerson());
        assertEquals(ordermap, order.getOrders());
    }

    @Test
    void isSameOrder_sameObject_returnsTrue() {
        Order order = new Order(person, ordermap);
        assertTrue(order.isSameOrder(order));
    }

    @Test
    void isSameOrder_differentId_returnsFalse() {
        Order order1 = new Order(person, ordermap);
        Order order2 = new Order(person, ordermap);
        assertFalse(order1.isSameOrder(order2));
    }

    @Test
    void isSameOrder_null_returnsFalse() {
        Order order = new Order(person, ordermap);
        assertFalse(order.isSameOrder(null));
    }

    @Test
    void equals_sameValue_returnsTrue() {
        Order order1 = new Order(person, ordermap);
        Order order2 = new Order(person, ordermap);
        assertEquals(order1, order2);
        assertEquals(order1.hashCode(), order2.hashCode());
    }

    @Test
    void equals_differentValue_returnsFalse() {
        Order order1 = new Order(person, ordermap);
        Order order2 = new Order(person, ordermap);
        assertNotEquals(order1, order2);
    }

    @Test
    void equals_otherObject_returnsFalse() {
        Order order = new Order(person, ordermap);
        assertNotEquals(order, null);
        assertNotEquals(order, "not an order");
    }

    @Test
    void toString_containsAllFields() {
        Order order = new Order(person, ordermap);
        String str = order.toString();
        assertTrue(str.contains("orderId"));
        assertTrue(str.contains("person"));
        assertTrue(str.contains("status"));
        assertTrue(str.contains("orderDateTime"));
    }
}
