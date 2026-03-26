package seedu.address.logic.commands.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.order.OrderDateTime;
import seedu.address.model.order.OrderMap;
import seedu.address.model.order.OrderStatus;
import seedu.address.model.person.Person;

/**
 * Contains integration tests (interaction with the Model) for {@code AddOrderCommand}.
 */
public class AddOrderCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        OrderMap.cleanIdx();
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_newOrder_success() throws Exception {
        int index = 1;

        Map<Integer, Integer> order = new HashMap<>();
        order.put(1, 2);
        order.put(2, 3);

        AddOrderCommand addOrderCommand = new AddOrderCommand(index, order);
        CommandResult result = addOrderCommand.execute(model);
        Person person = model.getFilteredPersonList().get(index - 1);
        OrderMap orderToAdd = new OrderMap(
                OrderMap.getNextId(), person, order, OrderStatus.PENDING, new OrderDateTime(LocalDateTime.now()));

        OrderMap addedOrder = model.getAddressBook().getOrderList().get(0);
        assertEquals(String.format(AddOrderCommand.MESSAGE_SUCCESS, Messages.format(addedOrder)),
                result.getFeedbackToUser());
        assertEquals(order, addedOrder.getOrderMap());
        assertEquals(model.getFilteredPersonList().get(index - 1), addedOrder.getPerson());
        assertEquals(1, model.getAddressBook().getOrderList().size());
    }
}
