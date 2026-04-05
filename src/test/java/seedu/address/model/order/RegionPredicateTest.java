package seedu.address.model.order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.model.person.Region;
import seedu.address.testutil.OrderBuilder;
import seedu.address.testutil.PersonBuilder;

public class RegionPredicateTest {

    @Test
    public void test_regionMatchesPendingOrder_returnsTrue() {
        RegionPredicate predicate = new RegionPredicate(new Region("N"));
        Person person = new PersonBuilder().withRegion("N").build();
        OrderMap order = new OrderBuilder().withPerson(person).build();
        assertTrue(predicate.test(order));
    }

    @Test
    public void test_regionDoesNotMatch_returnsFalse() {
        RegionPredicate predicate = new RegionPredicate(new Region("N"));
        Person person = new PersonBuilder().withRegion("E").build();
        OrderMap order = new OrderBuilder().withPerson(person).build();
        assertFalse(predicate.test(order));
    }

    @Test
    public void test_completedOrder_returnsFalse() {
        RegionPredicate predicate = new RegionPredicate(new Region("N"));
        Person person = new PersonBuilder().withRegion("N").build();
        OrderMap completedOrder = new OrderBuilder().withPerson(person).build().markAsCompleted();
        assertFalse(predicate.test(completedOrder));
    }
}

