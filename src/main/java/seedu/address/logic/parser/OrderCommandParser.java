package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CUSTOMERIDX;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORDERS;

import java.util.Map;
import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.OrderCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class OrderCommandParser implements Parser<OrderCommand> {

    public OrderCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(
                        args,
                        PREFIX_CUSTOMERIDX, PREFIX_ORDERS);

        if (!arePrefixesPresent(
                argMultimap,
                PREFIX_CUSTOMERIDX, PREFIX_ORDERS)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, OrderCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(
                PREFIX_CUSTOMERIDX);
        Index index = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_CUSTOMERIDX).get());
        Map<Integer, Integer> order = ParserUtil.parseOrders(argMultimap.getAllValues(PREFIX_ORDERS));

        return new OrderCommand(index, order);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}

