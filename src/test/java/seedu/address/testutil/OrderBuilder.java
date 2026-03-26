package seedu.address.testutil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import seedu.address.model.order.OrderMap;
import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Region;

/**
 * A utility class to help with building Order objects.
 */
public class OrderBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_ADDRESS = "123456";
    public static final String DEFAULT_REGION = "N";
    public static final String DEFAULT_UNITNO = "#01-01";
    public static final int DEFAULT_PRODUCT = 1;
    public static final int DEFAULT_QUANTITY = 2;

    private static final Person DEFAULT_PERSON = new Person(
            new Name(DEFAULT_NAME),
            new Phone(DEFAULT_PHONE),
            new Address(DEFAULT_ADDRESS, DEFAULT_UNITNO),
            new Region(DEFAULT_REGION),
            new HashSet<>());

    private static final Map<Integer, Integer> DEFAULT_ORDERMAP = new HashMap<>(DEFAULT_PRODUCT, DEFAULT_QUANTITY);

    private Person person;
    private Map<Integer, Integer> orders;

    /**
     * Creates a {@code OrderBuilder} with the default details.
     */
    public OrderBuilder() {
        person = DEFAULT_PERSON;
        orders = DEFAULT_ORDERMAP;
    }

    /**
     * Initializes the OrderBuilder with the data of {@code orderToCopy}.
     */
    public OrderBuilder(OrderMap orderToCopy) {
        person = orderToCopy.getPerson();
        orders = new HashMap<>(orderToCopy.getOrderMap());
    }

    /**
     * Sets the {@code person} of the {@code OrderMap} we are building.
     */
    public OrderBuilder withPerson(Person person) {
        this.person = person;
        return this;
    }

    /**
     * Parses the {@code orders} into a {@code Set<OrderMap>} and set it to the {@code Person} that we are building.
     */
    public OrderBuilder withOrderMap(String ... orders) {
        // TODO
        return this;
    }

    public OrderMap build() {
        return new OrderMap(person, orders);
    }

}
