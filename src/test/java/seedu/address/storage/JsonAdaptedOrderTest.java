package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.AddressBook;
import seedu.address.model.order.OrderDateTime;
import seedu.address.model.order.OrderMap;
import seedu.address.model.order.OrderStatus;
import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Region;

public class JsonAdaptedOrderTest {

    @Test
    public void saveAndLoadOrders() throws Exception, IllegalValueException {
        AddressBook ab = new AddressBook();

        Person person = new Person(
                new Name("Alice"),
                new Phone("98765432"),
                new Address("123456"),
                new Region("W"),
                new HashSet<>()
        );
        ab.addPerson(person);

        HashMap<Integer, Integer> items = new HashMap<>();
        items.put(1, 1);
        OrderMap order = new OrderMap(
                1,
                person,
                items,
                OrderStatus.PENDING,
                new OrderDateTime(LocalDateTime.parse("2026-03-10T10:15:30"))
        );
        ab.addOrder(order);

        JsonSerializableAddressBook json = new JsonSerializableAddressBook(ab);

        AddressBook loaded = json.toModelType();
        assertEquals(1, loaded.getOrderList().size());
    }
}
