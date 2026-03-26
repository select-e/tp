package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class CommandResultTest {
    @Test
    public void equals() {
        CommandResult commandResult = new CommandResult("feedback");

        // same values -> returns true
        assertTrue(commandResult.equals(new CommandResult("feedback")));
        assertTrue(commandResult.equals(new CommandResult("feedback", false, false)));

        // same object -> returns true
        assertTrue(commandResult.equals(commandResult));

        // null -> returns false
        assertFalse(commandResult.equals(null));

        // different types -> returns false
        assertFalse(commandResult.equals(0.5f));

        // different feedbackToUser value -> returns false
        assertFalse(commandResult.equals(new CommandResult("different")));

        // different showHelp value -> returns false
        assertFalse(commandResult.equals(new CommandResult("feedback", true, false)));

        // different exit value -> returns false
        assertFalse(commandResult.equals(new CommandResult("feedback", false, true)));
    }

    @Test
    public void hashcode() {
        CommandResult commandResult = new CommandResult("feedback");

        // same values -> returns same hashcode
        assertEquals(commandResult.hashCode(), new CommandResult("feedback").hashCode());

        // different feedbackToUser value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new CommandResult("different").hashCode());

        // different showHelp value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new CommandResult("feedback", true, false).hashCode());

        // different exit value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new CommandResult("feedback", false, true).hashCode());
    }

    @Test
    public void toStringMethod() {
        CommandResult commandResult = new CommandResult("feedback");
        String expected = CommandResult.class.getCanonicalName() + "{feedbackToUser=feedback,"
                + " showHelp=false, exit=false, showPersons=false, showOrders=false}";
        assertEquals(expected, commandResult.toString());
    }

    @Test
    public void commandMutability_defaultBehavioursReturnFalse() {
        Command nonMutating = new Command() {
            @Override
            public CommandResult execute(Model model) throws CommandException {
                return new CommandResult("noop");
            }
        };
        assertFalse(nonMutating.shouldRecordInHistory());
        assertFalse(nonMutating.mutatesModel());
    }

    @Test
    public void commandMutability_overridesReturnTrue() {
        Command mutating = new Command() {
            @Override
            public CommandResult execute(Model model) throws CommandException {
                return new CommandResult("mutate");
            }

            @Override
            public boolean shouldRecordInHistory() {
                return true;
            }

            @Override
            public boolean mutatesModel() {
                return true;
            }
        };
        assertTrue(mutating.shouldRecordInHistory());
        assertTrue(mutating.mutatesModel());
    }

    @Test
    public void commandMutability_mutatesModelWithoutHistoryCommit() {
        Command storageOnly = new Command() {
            @Override
            public CommandResult execute(Model model) throws CommandException {
                return new CommandResult("storage");
            }

            @Override
            public boolean mutatesModel() {
                return true;
            }
        };
        assertFalse(storageOnly.shouldRecordInHistory());
        assertTrue(storageOnly.mutatesModel());
    }
}
