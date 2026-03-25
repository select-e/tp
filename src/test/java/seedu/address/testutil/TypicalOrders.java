package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.order.OrderMap;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Order} objects to be used in tests.
 */
public class TypicalOrders {

    public static final OrderMap ALICE_ORDER = new OrderBuilder().withPerson(TypicalPersons.ALICE)
            .withOrderMap("1 2", "2 4").build();
    public static final OrderMap BENSON_ORDER = new OrderBuilder().withPerson(TypicalPersons.BENSON)
            .withOrderMap("2 1", "3 6", "1 1").build();
    public static final OrderMap CARL_ORDER = new OrderBuilder().withPerson(TypicalPersons.CARL)
            .withOrderMap("1 1").build();
    public static final OrderMap DANIEL_ORDER = new OrderBuilder().withPerson(TypicalPersons.DANIEL)
            .withOrderMap("4 1").build();
    public static final OrderMap ELLE_ORDER = new OrderBuilder().withPerson(TypicalPersons.ELLE)
            .withOrderMap("4 4").build();
    public static final OrderMap FIONA_ORDER = new OrderBuilder().withPerson(TypicalPersons.FIONA)
            .withOrderMap("5 1").build();
    public static final OrderMap GEORGE_ORDER = new OrderBuilder().withPerson(TypicalPersons.GEORGE)
            .withOrderMap("2 2", "4 2").build();

    // Manually added
    public static final OrderMap HOON_ORDER = new OrderBuilder().withPerson(TypicalPersons.HOON)
            .withOrderMap("1 1", "2 2").build();
    public static final OrderMap IDA_ORDER = new OrderBuilder().withPerson(TypicalPersons.IDA)
            .withOrderMap("3 2", "4 3").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final OrderMap AMY_ORDER = new OrderBuilder().withPerson(TypicalPersons.AMY)
            .withOrderMap("3 2", "4 4").build();
    public static final OrderMap BOB_ORDER = new OrderBuilder().withPerson(TypicalPersons.BOB)
            .withOrderMap("1 2", "3 1").build();

    private TypicalOrders() {} // prevents instantiation

    /**
     * Returns an AddressBook with typical orders.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();

        ab.addPerson(TypicalPersons.ALICE);
        ab.addPerson(TypicalPersons.BENSON);
        ab.addPerson(TypicalPersons.CARL);
        ab.addPerson(TypicalPersons.DANIEL);

        for (OrderMap order : getTypicalOrders()) {
            ab.addOrder(order);
        }

        return ab;
    }

    public static List<OrderMap> getTypicalOrders() {
        return new ArrayList<>(Arrays.asList(ALICE_ORDER, BENSON_ORDER, CARL_ORDER, DANIEL_ORDER, ELLE_ORDER, FIONA_ORDER, GEORGE_ORDER));
    }
}
