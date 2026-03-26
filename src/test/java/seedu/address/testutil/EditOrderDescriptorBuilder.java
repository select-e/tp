package seedu.address.testutil;

import java.util.HashMap;
import java.util.Map;

import seedu.address.logic.commands.order.EditOrderCommand.EditOrderDescriptor;
import seedu.address.model.order.OrderMap;

/**
 * A utility class to help with building EditOrderDescriptor objects.
 */
public class EditOrderDescriptorBuilder {

    private final EditOrderDescriptor descriptor;

    public EditOrderDescriptorBuilder() {
        descriptor = new EditOrderDescriptor();
    }

    public EditOrderDescriptorBuilder(EditOrderDescriptor descriptor) {
        this.descriptor = new EditOrderDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditOrderDescriptor} with fields containing {@code order}'s details
     */
    public EditOrderDescriptorBuilder(OrderMap order) {
        descriptor = new EditOrderDescriptor();
        descriptor.setOrderMap(order.getOrderMap());
    }

    /**
     * Sets the {@code orderMap} of the {@code EditOrderDescriptor} that we are building.
     */
    public EditOrderDescriptorBuilder withOrderMap(String... orders) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String order : orders) {
            String[] pair = order.split(" ", 2);
            String product = pair[0];
            String quantity = pair[1];
            map.put(Integer.parseInt(product), Integer.parseInt(quantity));
        }
        descriptor.setOrderMap(map);
        return this;
    }

    public EditOrderDescriptor build() {
        return descriptor;
    }
}
