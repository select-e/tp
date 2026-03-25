package seedu.address.logic.parser.order;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CUSTOMERIDX;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORDERS;

import java.util.Map;
import java.util.stream.Stream;

<<<<<<< HEAD
import seedu.address.logic.commands.person.AddPersonCommand;
=======
import seedu.address.logic.commands.order.AddCommand;
>>>>>>> add-orders
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;

<<<<<<< HEAD
/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddPersonCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddPersonCommand parse(String args) throws ParseException {
=======
public class AddCommandParser implements Parser<AddCommand> {

    public AddCommand parse(String args) throws ParseException {
>>>>>>> add-orders
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(
                        args,
                        PREFIX_CUSTOMERIDX, PREFIX_ORDERS);

        if (!arePrefixesPresent(
                argMultimap,
                PREFIX_CUSTOMERIDX, PREFIX_ORDERS)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddPersonCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_CUSTOMERIDX);
        int index = Integer.parseInt(argMultimap.getValue(PREFIX_CUSTOMERIDX).get());
        Map<Integer, Integer> order = ParserUtil.parseOrders(argMultimap.getAllValues(PREFIX_ORDERS));

<<<<<<< HEAD
        Person person = new Person(name, phone, email, address, region, order, tagList);

        return new AddPersonCommand(person);
=======
        return new AddCommand(index, order);
>>>>>>> add-orders
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}

