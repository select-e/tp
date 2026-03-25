package seedu.address.logic.parser.order;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORDERS;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.order.EditOrderCommand;
import seedu.address.logic.commands.order.EditOrderCommand.EditOrderDescriptor;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.order.ProductQuantityPair;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser implements Parser<EditOrderCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditOrderCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_ORDERS);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditOrderCommand.MESSAGE_USAGE), pe);
        }

        EditOrderDescriptor editOrderDescriptor = new EditOrderDescriptor();

        if (argMultimap.getValue(PREFIX_ORDERS).isPresent()) {
            ProductQuantityPair productQuantityPair =
                    ParserUtil.parseProductQuantityPair(argMultimap.getValue(PREFIX_ORDERS).get());
            editOrderDescriptor.setProduct(productQuantityPair.getProduct());
            editOrderDescriptor.setQuantity(productQuantityPair.getQuantity().map(q -> q.value).orElse(0));
        } else {
            throw new ParseException(EditOrderCommand.MESSAGE_NOT_EDITED);
        }

        return new EditOrderCommand(index, editOrderDescriptor);
    }
}
