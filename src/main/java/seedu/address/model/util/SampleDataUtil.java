package seedu.address.model.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.order.OrderMap;
import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Region;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"),
                    new Address("389729"), new Region("E"),
                    getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"),
                    new Address("556083"), new Region("N"),
                    getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"),
                    new Address("560111"), new Region("E"),
                    getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"),
                    new Address("610436"), new Region("W"),
                    getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"),
                    new Address("520047"), new Region("C"),
                    getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"),
                    new Address("380045"), new Region("NE"),
                    getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        Person[] samplePersons = getSamplePersons();

        for (Person samplePerson : samplePersons) {
            sampleAb.addPerson(samplePerson);
        }

        for (OrderMap sampleOrder : getSampleOrders(samplePersons)) {
            sampleAb.addOrder(sampleOrder);
        }

        return sampleAb;
    }

    /**
     * Returns sample orders tagged to sample persons.
     */
    public static OrderMap[] getSampleOrders(Person[] persons) {
        return new OrderMap[] {
            new OrderMap(persons[0], getOrderMap(1, 2, 7, 1)),
            new OrderMap(persons[1], getOrderMap(2, 1, 8, 1)),
            new OrderMap(persons[2], getOrderMap(3, 1)),
            new OrderMap(persons[4], getOrderMap(4, 2, 5, 1))
        };
    }

    /**
     * Returns an order map from menu item and quantity pairs.
     */
    private static Map<Integer, Integer> getOrderMap(int... pairs) {
        Map<Integer, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < pairs.length - 1; i += 2) {
            orderMap.put(pairs[i], pairs[i + 1]);
        }
        return orderMap;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
