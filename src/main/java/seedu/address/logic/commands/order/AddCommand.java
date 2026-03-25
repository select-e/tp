package seedu.address.logic.commands.order;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CUSTOMERIDX;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORDERS;

import java.util.Map;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.order.OrderMap;
import seedu.address.model.person.Person;

/** for adding a new order with a returning customer **/

public class AddCommand extends Command {
    public static final String COMMAND_WORD = "addorder";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": adds a new order made by a returning customer. "
            + "Parameters: " + PREFIX_CUSTOMERIDX + "CUSTOMER_INDEX (must be a positive integer) "
            + "o/ [MENU_ITEM PRODUCT_QUANTITY]\n"
            + "Example: " + COMMAND_WORD + PREFIX_CUSTOMERIDX + " 1 " + PREFIX_ORDERS + "1 1" + PREFIX_ORDERS + "2 4\n"
            + "This means customer 1 ordered 1 of menu item 1 and 4 of menu item 2.";

    public static final String MESSAGE_SUCCESS = "New order added: %1$s.";

    private final int index;
    private final Map<Integer, Integer> order;

    public AddCommand(int index, Map<Integer, Integer> order) {
        requireAllNonNull(index, order);
        this.index = index;
        this.order = order;
    }

    @Override
    public CommandResult execute(Model model) {
        Person person = model.getFilteredPersonList().get(index);
        OrderMap toAdd = new OrderMap(person, this.order);
        model.addOrder(toAdd);

        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddCommand)) {
            return false;
        }

        AddCommand e = (AddCommand) other;
        return index == e.index && order.equals(e.order);
    }
}
