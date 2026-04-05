# ListOrder Test Report

## Scope
Non-GUI testing for the `listorder` feature, covering parser behavior, command execution, and model-side effects. GUI checks are listed as suggestions only.

## Test approaches used
1. Parser-level tests to validate command word handling, whitespace tolerance, and extraneous argument acceptance.
2. Command-level tests to validate `ListOrderCommand` feedback messages and UI flags.
3. Integration tests to verify interaction with `ModelManager` filtered order list state.

## Test cases added
- `listorder` with leading whitespace: parser trims and accepts the command.
- `listorder` on empty order list: returns "No orders found" and sets `showOrders` flag.
- `listorder` on non-empty order list: returns success message and sets `showOrders` flag.
- `listorder` after order list is filtered to empty: resets the filtered list to show all orders.

## Existing coverage (confirmed)
- Parser accepts `listorder` and ignores extraneous arguments.
- `equals` returns true for another `ListOrderCommand` instance.

## Potential bugs / inconsistencies found
1. **Message check relies on `getAddressBook().getOrderList()` instead of filtered list.** If a future `Model` implementation decouples the filtered list from the address book list, the "No orders found" decision could be inconsistent with what the UI shows.
2. **UI always switches to the orders view even when the order list is empty.** This is probably intended, but could be surprising if users expect to stay on the current view after a no-op list.

## Suggestions
1. Consider using `model.getFilteredOrderList()` after applying `PREDICATE_SHOW_ALL_ORDERS` for the empty-list check to keep message logic consistent with displayed list state.
2. If the intended UX is to keep the current view when there are zero orders, consider setting `showOrders` to false for the empty case and adding a separate flag or message.

## GUI test suggestions (left to you)
1. Verify `listorder` switches to the order list panel and shows all orders.
2. Verify `listorder` shows an empty list panel with the "No orders found" message when there are no orders.
3. Verify `listorder` resets any prior order filtering in the UI (e.g., after `find`-like features on orders if added later).
