package seedu.address.logic.parser.order;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
<<<<<<< HEAD
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORDERS;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.order.EditOrderCommand;
import seedu.address.logic.commands.order.EditOrderCommand.EditOrderDescriptor;
=======
import static seedu.address.logic.parser.CliSyntax.PREFIX_CUSTOMERIDX;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORDERS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.person.EditCommand;
>>>>>>> add-orders
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
<<<<<<< HEAD
                ArgumentTokenizer.tokenize(args, PREFIX_ORDERS);
=======
                ArgumentTokenizer.tokenize(args, PREFIX_CUSTOMERIDX, PREFIX_ORDERS);
>>>>>>> add-orders

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditOrderCommand.MESSAGE_USAGE), pe);
        }

<<<<<<< HEAD
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
=======
        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_CUSTOMERIDX);

        /*
        if (argMultimap.getValue(PREFIX_ORDERS).isPresent()) {
            editPersonDescriptor.setOrder(new ArrayList<>(List.of(ParserUtil.parseOrder(argMultimap.getValue(PREFIX_ORDERS).get()))));
        }

        if (!editPersonDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditCommand.MESSAGE_NOT_EDITED);
        }
        */
        return null; // new EditCommand(index, editPersonDescriptor);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>} if {@code tags} is non-empty.
     * If {@code tags} contain only one element which is an empty string, it will be parsed into a
     * {@code Set<Tag>} containing zero tags.
     */
/*
    private Optional<Set<Tag>> parseTagsForEdit(Collection<String> tags) throws ParseException {
        assert tags != null;

        if (tags.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> tagSet = tags.size() == 1 && tags.contains("") ? Collections.emptySet() : tags;
        return Optional.of(ParserUtil.parseTags(tagSet));
    }

*/
>>>>>>> add-orders
}
