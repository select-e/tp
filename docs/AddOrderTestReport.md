# AddOrder Test Report

## Scope
Non-GUI testing for the `addorder` feature, covering parser behavior, command execution, and model-side effects. GUI checks are listed as suggestions only.

## Test approaches used
1. Parser-level tests to validate required prefixes, whitespace tolerance, and invalid order inputs.
2. Command-level tests to validate `AddOrderCommand` core behavior and flags.
3. Integration tests to verify interaction with `ModelManager` and filtered order list state.

## Test cases added
- `addorder` with multiple order items: parser accepts multiple `o/` prefixes and creates the correct `AddOrderCommand`.
- `addorder` with leading whitespace: parser trims and accepts the command.
- `addorder` missing `c/` or `o/`: parser rejects with invalid format.
- `addorder` with duplicate `c/`: parser rejects with duplicate-prefix error.
- `addorder` with invalid menu item or zero quantity: parser rejects with the correct error message.
- `addorder` after filtered order list is empty: adding an order resets the order list filter.

## Existing coverage (confirmed)
- Constructor rejects null order map.
- Successful execution adds a new order and returns the success message.
- `equals`, mutability flags (`shouldRecordInHistory`, `mutatesModel`) are covered.
- Parser basic success case returns an `AddOrderCommand` instance.

## Potential bugs / inconsistencies found
1. **Customer index is not validated in the parser.** `AddOrderCommandParser` uses `Integer.parseInt` directly, so non-integer input throws a `NumberFormatException` (not a `ParseException`). Index `0` or negative values also pass parsing and later cause `IndexOutOfBoundsException` in `AddOrderCommand.execute`.
2. **No bounds check against the filtered person list.** `AddOrderCommand.execute` blindly accesses `get(index - 1)`; when the list is empty or the index is too large, this crashes instead of returning a user-facing error.
3. **Duplicate menu item inputs are not resolved.** `o/1 1 o/1 2` produces two `ProductQuantityPair` entries for the same product (because equality includes quantity). This can lead to inconsistent totals or duplicate items in the same order.
4. **Exact duplicate items are silently dropped.** Because a `Set` is used, `o/1 2 o/1 2` keeps only one entry without warning.

## Suggestions
1. Use `ParserUtil.parseIndex` for `c/` and return `MESSAGE_INVALID_COMMAND_FORMAT` on invalid index formats.
2. Validate index bounds in `AddOrderCommand.execute` and throw a `CommandException` with `Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX` when out of range.
3. Decide a policy for duplicate menu items and enforce it (e.g., merge quantities, or reject duplicates explicitly).
4. Add parser tests for duplicate menu items once the desired behavior is finalized.

## GUI test suggestions (left to you)
1. Verify the order list refreshes to show the newly added order even after a filter.
2. Verify error feedback for invalid customer index and invalid menu items.
3. Confirm UI reflects the correct customer and item list in the order details panel after `addorder`.
