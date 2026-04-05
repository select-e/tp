# Clear Test Report

## Scope
Non-GUI testing for the `clear` feature, covering parser behavior, command execution, and model-side effects. GUI checks are listed as suggestions only.

## Test approaches used
1. Parser-level tests to validate command word handling, whitespace tolerance, and extraneous argument acceptance.
2. Command-level tests to validate `ClearCommand` feedback and mutability flags.
3. Integration tests to verify interaction with `ModelManager`, including orders and filtered list state.

## Test cases added
- `clear` with leading whitespace: parser trims and accepts the command.
- `clear` with trailing whitespace: parser accepts the command.
- `clear` on a non-empty address book with orders: clears both persons and orders.
- `clear` when person and order lists are filtered to none: clears data without errors and keeps filters consistent.

## Existing coverage (confirmed)
- `clear` on an empty address book succeeds.
- `clear` on a non-empty person list succeeds.
- Mutability flags (`shouldRecordInHistory`, `mutatesModel`) are covered.
- Parser accepts `clear` and ignores extra arguments.

## Potential bugs / inconsistencies found
1. **Filters are not reset after clear.** If a user previously filtered persons or orders to none, a subsequent `clear` keeps the predicate; after adding new data, lists may remain empty until a manual `list` command is run.
2. **`clear` ignores trailing arguments.** This is consistent with current parser behavior but may be unexpected to users (e.g., `clear 123` succeeds without warning).
3. **No view-switching flag is set.** `clear` does not set `showPersons` or `showOrders`, so the UI view depends entirely on the prior state.

## Suggestions
1. Consider resetting both filtered lists to `PREDICATE_SHOW_ALL_*` inside `ClearCommand.execute` to avoid hidden data after clear.
2. Decide whether `clear` should reject extra arguments and enforce it in the parser for consistency with other no-arg commands.
3. If the intended UX is to always land on a default view after clear, set `showPersons` (or another explicit flag) in the `CommandResult`.

## GUI test suggestions (left to you)
1. Verify `clear` empties both the person and order panels (if orders are shown).
2. Verify the UI view after `clear` is consistent with the intended default (persons vs orders).
3. Verify filters are not silently preserved in the UI (e.g., add a new person after `clear` and check whether it appears).
