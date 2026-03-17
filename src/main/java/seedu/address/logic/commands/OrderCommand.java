package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.HashMap;
import java.util.Map;

import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;

/** for adding a new order with a returning customer **/

public class OrderCommand extends Command {
    public static final String COMMAND_WORD = "order";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": adds a new order made by a returning customer. "
            + "Parameters: CUSTOMER_INDEX (must be a positive integer) "
            + "o/ [PRODUCT QUANTITY]\n"
            + "Example: " + COMMAND_WORD + " 1 " + "o/ 1 1 o/ 2 4 \n"
            + "This means customer 1 ordered 1 of menu item 1 and 4 of menu item 2.";

    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Remark: %2$s";

    private final Index index;
    private Map<Integer, Integer> order = new HashMap<>();

    public OrderCommand(Index index, Map<Integer, Integer> order) {
        requireAllNonNull(index, order);
        this.index = index;
        this.order = order;
    }

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult("i want food");
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
        return index.equals(e.index)
                && order.equals(e.order);
    }
}
