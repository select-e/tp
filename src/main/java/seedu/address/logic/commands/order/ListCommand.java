package seedu.address.logic.commands.order;

import static java.util.Objects.requireNonNull;

import javafx.collections.ObservableList;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.order.Order;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "listorder";

    public static final String MESSAGE_SUCCESS = "Listed all orders";

    public static final String MESSAGE_NO_CONTACTS = "No orders found";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        ObservableList<Order> orderList = model.getAddressBook().getOrderList();
        if (orderList.isEmpty()) {
            return new CommandResult(MESSAGE_NO_CONTACTS);
        }

        // Placeholder print statements
        System.out.println("Initial data:");
        java.util.List<seedu.address.model.order.Order> list = model.getAddressBook().getOrderList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + Messages.format(list.get(i)));
        }

        return new CommandResult(MESSAGE_SUCCESS);
    }
}
