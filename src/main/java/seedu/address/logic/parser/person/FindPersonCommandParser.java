<<<<<<<< HEAD:src/main/java/seedu/address/logic/parser/order/FindCommandParser.java
package seedu.address.logic.parser.order;
========
package seedu.address.logic.parser.person;
>>>>>>>> master:src/main/java/seedu/address/logic/parser/person/FindPersonCommandParser.java

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

<<<<<<<< HEAD:src/main/java/seedu/address/logic/parser/order/FindCommandParser.java
import seedu.address.logic.commands.person.FindCommand;
========
import seedu.address.logic.commands.person.FindPersonCommand;
>>>>>>>> master:src/main/java/seedu/address/logic/parser/person/FindPersonCommandParser.java
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.RegionContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindPersonCommand object
 */
public class FindPersonCommandParser implements Parser<FindPersonCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindPersonCommand
     * and returns a FindPersonCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindPersonCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPersonCommand.MESSAGE_USAGE));
        }

        String[] regionKeywords = trimmedArgs.split("\\s+");

        return new FindPersonCommand(new RegionContainsKeywordsPredicate(Arrays.asList(regionKeywords)));
    }

}
