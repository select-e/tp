package seedu.address.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.AddressBook;
import seedu.address.model.order.*;
import seedu.address.model.person.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonAdaptedOrderTest {

    @Test
    public void saveAndLoadOrders() throws Exception, IllegalValueException {
        AddressBook ab = new AddressBook();

        Person person = new Person(
                new Name("Alice"),
                new Phone("98765432"),
                new Email("alice@gmail.com"),
                new Address("123456"),
                new Region("W"),
                new ArrayList<>(),
                new HashSet<>()
        );
        ab.addPerson(person);

        Order order = new Order(
                new OrderId("1"),
                person,
                new Product("Laptop"),
                new Quantity("2"),
                new Price("1500"),
                OrderStatus.PENDING,
                new OrderDate(LocalDate.parse("2026-03-10"))
        );
        ab.addOrder(order);

        JsonSerializableAddressBook json = new JsonSerializableAddressBook(ab);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonString = mapper.writeValueAsString(json);
        System.out.println("Json:");
        System.out.println(jsonString);

        AddressBook loaded = json.toModelType();
        assertEquals(1, loaded.getOrderList().size());
    }
}
