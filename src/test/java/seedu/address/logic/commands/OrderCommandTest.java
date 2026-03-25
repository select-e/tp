package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.order.Order;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

<<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/person/AddPersonCommandTest.java
public class AddPersonCommandTest {

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddPersonCommand(null));
========
public class OrderCommandTest {

    @Test
    public void constructor_nullOrder_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new OrderCommand(1, null));
>>>>>>>> add-orders:src/test/java/seedu/address/logic/commands/OrderCommandTest.java
    }

    @Test
    public void execute_orderAcceptedByModel_addSuccessful() {
        ModelStubAcceptingOrderAdded modelStub = new ModelStubAcceptingOrderAdded();

<<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/person/AddPersonCommandTest.java
        CommandResult commandResult = new AddPersonCommand(validPerson).execute(modelStub);

        assertEquals(String.format(AddPersonCommand.MESSAGE_SUCCESS, Messages.format(validPerson)),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validPerson), modelStub.personsAdded);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Person validPerson = new PersonBuilder().build();
        AddPersonCommand addCommand = new AddPersonCommand(validPerson);
        ModelStub modelStub = new ModelStubWithPerson(validPerson);

        assertThrows(CommandException.class, AddPersonCommand.MESSAGE_DUPLICATE_PERSON, () -> addCommand.execute(modelStub));
========
        Map<Integer, Integer> orderMap = new HashMap<>();
        orderMap.put(1, 2);

        OrderCommand orderCommand = new OrderCommand(1, orderMap);

        CommandResult commandResult = orderCommand.execute(modelStub);

        Order expectedOrder = new Order(modelStub.getFilteredPersonList().get(1), orderMap);

        assertEquals(
                String.format(OrderCommand.MESSAGE_SUCCESS, Messages.format(expectedOrder)),
                commandResult.getFeedbackToUser()
        );

        assertEquals(Arrays.asList(expectedOrder), modelStub.ordersAdded);
>>>>>>>> add-orders:src/test/java/seedu/address/logic/commands/OrderCommandTest.java
    }

    @Test
    public void equals() {
<<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/person/AddPersonCommandTest.java
        Person alice = new PersonBuilder().withName("Alice").build();
        Person bob = new PersonBuilder().withName("Bob").build();
        AddPersonCommand addAliceCommand = new AddPersonCommand(alice);
        AddPersonCommand addBobCommand = new AddPersonCommand(bob);
========
        Map<Integer, Integer> order1 = new HashMap<>();
        order1.put(1, 2);
>>>>>>>> add-orders:src/test/java/seedu/address/logic/commands/OrderCommandTest.java

        Map<Integer, Integer> order2 = new HashMap<>();
        order2.put(2, 3);

<<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/person/AddPersonCommandTest.java
        // same values -> returns true
        AddPersonCommand addAliceCommandCopy = new AddPersonCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));
========
        OrderCommand command1 = new OrderCommand(1, order1);
        OrderCommand command2 = new OrderCommand(2, order2);
>>>>>>>> add-orders:src/test/java/seedu/address/logic/commands/OrderCommandTest.java

        // same object
        assertTrue(command1.equals(command1));

        // same values
        OrderCommand command1Copy = new OrderCommand(1, order1);
        assertTrue(command1.equals(command1Copy));

        // different types
        assertFalse(command1.equals(1));

        // null
        assertFalse(command1.equals(null));

        // different index
        assertFalse(command1.equals(command2));
    }
<<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/person/AddPersonCommandTest.java

    @Test
    public void toStringMethod() {
        AddPersonCommand addCommand = new AddPersonCommand(ALICE);
        String expected = AddPersonCommand.class.getCanonicalName() + "{toAdd=" + ALICE + "}";
        assertEquals(expected, addCommand.toString());
    }

    @Test
    public void mutabilityFlags_returnsTrue() {
        AddPersonCommand addCommand = new AddPersonCommand(new PersonBuilder().build());
        assertTrue(addCommand.shouldRecordInHistory());
        assertTrue(addCommand.mutatesModel());
    }

========
>>>>>>>> add-orders:src/test/java/seedu/address/logic/commands/OrderCommandTest.java
    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addOrder(Order order) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasOrder(Order order) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Person target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteOrder(Order target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Person target, Person editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setOrder(Order target, Order editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Order> getFilteredOrderList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Person> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        public void updateFilteredOrderList(Predicate<Order> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean canUndoAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean canRedoAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void undoAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void redoAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void commitAddressBook() {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that always accepts orders.
     */
    private class ModelStubAcceptingOrderAdded extends ModelStub {
        final ArrayList<Order> ordersAdded = new ArrayList<>();
        private final Person defaultPerson = new PersonBuilder().build();

        @Override
        public void addOrder(Order order) {
            requireNonNull(order);
            ordersAdded.add(order);
        }
    }
}