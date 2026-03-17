package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Map;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.order.Order;
import seedu.address.model.person.Person;

/** for adding a new order with a returning customer **/

public class OrderCommand extends Command {
    public static final String COMMAND_WORD = "order";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": adds a new order made by a returning customer. "
            + "Parameters: CUSTOMER_INDEX (must be a positive integer) "
            + "o/ [PRODUCT QUANTITY]\n"
            + "Example: " + COMMAND_WORD + " 1 " + "o/ 1 1 o/ 2 4 \n"
            + "This means customer 1 ordered 1 of menu item 1 and 4 of menu item 2.";

    public static final String MESSAGE_SUCCESS = "New order added: %1$s.";

    private final int index;
    private final Map<Integer, Integer> order;

    public OrderCommand(int index, Map<Integer, Integer> order) {
        requireAllNonNull(index, order);
        this.index = index;
        this.order = order;
    }

    @Override
    public CommandResult execute(Model model) {
        Person person = model.getPerson(index);
        Order toAdd = new Order(person, this.order);
        model.addOrder(toAdd);

        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof OrderCommand)) {
            return false;
        }

        OrderCommand e = (OrderCommand) other;
        return index == e.index && order.equals(e.order);
    }
}
