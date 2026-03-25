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
import seedu.address.model.util.SampleDataUtil;

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

    Person DEFAULT_PERSON = new Person(
            new Name(DEFAULT_NAME),
            new Phone(DEFAULT_PHONE),
            new Address(DEFAULT_ADDRESS, DEFAULT_UNITNO),
            new Region(DEFAULT_REGION),
            new HashSet<>());

    Map<Integer, Integer> DEFAULT_ORDERMAP = new HashMap<>(DEFAULT_PRODUCT, DEFAULT_QUANTITY);

    private Person person;
    private Map<Integer, Integer> orders;

    /**
     * Creates a {@code OrderBuilder} with the default details.
     */
    public OrderBuilder() {
        person = DEFAULT_PERSON;
        orders = DEFAULT_ORDERMAP;
    }

    public OrderBuilder(OrderMap orderToCopy) {
        person = orderToCopy.getPerson();
        orders = new HashMap<>(orderToCopy.getOrderMap());
    }

    /**
     * Sets the {@code Person} of the {@code Order} that we are building.
     */
    public OrderBuilder withPerson(String name, String phone, String address, String unit, String region, String tags) {
        this.person = new Person(
                new Name(name),
                new Phone(phone),
                new Address(address, unit),
                new Region(region),
                new HashSet<>());
        return this;
    }

    public OrderBuilder withPerson(Person person) {
        this.person = person;
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public OrderBuilder withOrderMap(String ... orders) {
        this.orders = SampleDataUtil.parseOrders(orders);
        return this;
    }

    public OrderMap build() {
        return new OrderMap(person, orders);
    }

}
