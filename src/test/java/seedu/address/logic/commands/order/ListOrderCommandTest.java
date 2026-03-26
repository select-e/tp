package seedu.address.logic.commands.order;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ListOrderCommandTest {
    @Test
    public void equals_sameType_returnsTrue() {
        assertTrue(new ListOrderCommand().equals(new ListOrderCommand()));
    }
}
