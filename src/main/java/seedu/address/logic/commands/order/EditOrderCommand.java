package seedu.address.logic.commands.order;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORDERS;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_ORDERS;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.order.Order;
import seedu.address.model.order.Product;
import seedu.address.model.order.Quantity;


/**
 * Edits the details of an existing person in the address book.
 */
public class EditOrderCommand extends Command {

    public static final String COMMAND_WORD = "editorder";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the order identified "
            + "by the index number used in the displayed order list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_ORDERS + "MENU_ITEM PRODUCT_QUANTITY...\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_ORDERS + "5 2 "
            + PREFIX_ORDERS + "8 0";

    public static final String MESSAGE_EDIT_ORDER_SUCCESS = "Order edited successfully.\n%1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";

    private final Index index;
    private final EditOrderDescriptor editOrderDescriptor;

    /**
     * @param index of the order in the filtered person list to edit
     * @param editOrderDescriptor details to edit the order with
     */
    public EditOrderCommand(Index index, EditOrderDescriptor editOrderDescriptor) {
        requireNonNull(index);
        requireNonNull(editOrderDescriptor);

        this.index = index;
        this.editOrderDescriptor = new EditOrderDescriptor(editOrderDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Order> lastShownList = model.getFilteredOrderList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ORDER_DISPLAYED_INDEX);
        }

        Order orderToEdit = lastShownList.get(index.getZeroBased());
        Order editedOrder = createEditedOrder(orderToEdit, editOrderDescriptor);

        model.setOrder(orderToEdit, editedOrder);
        model.updateFilteredOrderList(PREDICATE_SHOW_ALL_ORDERS);
        return new CommandResult(String.format(MESSAGE_EDIT_ORDER_SUCCESS, Messages.format(editedOrder)));
    }

    /**
     * Creates and returns an {@code Order} with the details of {@code orderToEdit}
     * edited with {@code editOrderDescriptor}.
     */
    private static Order createEditedOrder(Order orderToEdit, EditOrderDescriptor editOrderDescriptor) {
        assert orderToEdit != null;

        Product updatedProduct = editOrderDescriptor.getProduct().orElse(orderToEdit.getProduct());
        Integer updatedQuantity = editOrderDescriptor.getQuantity();

        if (updatedQuantity == 0) {
            System.out.println("Zero quantity entered. This functionality hasn't been implemented yet.");
            return orderToEdit;
        }

        Quantity positiveQuantity = new Quantity(updatedQuantity.toString());

        // TODO: Calculate price
        return new Order(orderToEdit.getOrderId(), orderToEdit.getPerson(), updatedProduct, positiveQuantity,
                orderToEdit.getPrice(), orderToEdit.getOrderStatus(), orderToEdit.getDate());
    }

    @Override
    public boolean shouldRecordInHistory() {
        return true;
    }

    @Override
    public boolean mutatesModel() {
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditOrderCommand)) {
            return false;
        }

        EditOrderCommand otherEditCommand = (EditOrderCommand) other;
        return index.equals(otherEditCommand.index)
                && editOrderDescriptor.equals(otherEditCommand.editOrderDescriptor);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("index", index)
                .add("editPersonDescriptor", editOrderDescriptor)
                .toString();
    }

    /**
     * Stores the details to edit the person with. Each non-empty field value will replace the
     * corresponding field value of the person.
     */
    public static class EditOrderDescriptor {
        private Product product;
        private Integer quantity;

        public EditOrderDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditOrderDescriptor(EditOrderDescriptor toCopy) {
            setProduct(toCopy.product);
            setQuantity(toCopy.quantity);
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public Optional<Product> getProduct() {
            return Optional.ofNullable(product);
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getQuantity() {
            return quantity;
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditOrderDescriptor)) {
                return false;
            }

            EditOrderDescriptor otherEditOrderDescriptor = (EditOrderDescriptor) other;
            return Objects.equals(product, otherEditOrderDescriptor.product)
                    && Objects.equals(quantity, otherEditOrderDescriptor.quantity);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .add("product", product)
                    .add("quantity", quantity)
                    .toString();
        }
    }
}
