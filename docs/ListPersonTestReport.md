# ListPerson Test Report

## Scope
Non-GUI testing for the `listperson` feature, covering parser behavior, command execution, and model-side effects. GUI checks are outlined as suggestions only.

## Test approaches used
1. Parser-level tests to validate command word handling, whitespace tolerance, and ignored arguments.
2. Command-level integration tests that execute `listperson` against a `ModelManager` and verify `CommandResult` and model state.
3. State-invariant tests to ensure unrelated model filters (orders) are not mutated.

## Test cases added
- `listperson` after filtered list is empty: confirms it resets to show all persons and returns success message.
- `listperson` does not affect the filtered order list: ensures non-person filters remain unchanged.
- `listperson` with leading whitespace: parser trims and accepts the command.

## Existing coverage (confirmed)
- Basic `listperson` from unfiltered list returns success.
- `listperson` from a filtered-to-one list returns success.
- `listperson` on empty address book returns "No customer contacts found".
- `listperson` with extra arguments is accepted.

## Potential bugs / inconsistencies found
1. **User guide mismatch for list command.** The Quick Start examples use `list`, but the parser only recognizes `listperson`. The `list` alias will throw an unknown command error.
2. **Dead/unused command class.** `ListCommand` exists with command word `list` but is never referenced in the parser. This can confuse contributors and users.

## Suggestions
1. Decide on command word consistency:
   - If `list` should be supported, add it to the parser and update the user guide.
   - If `listperson` is the only command, update Quick Start examples to use `listperson` and remove or deprecate `ListCommand`.
2. Consider adding a parser test for the `list` alias (either expecting success or failure) once the desired behavior is settled.

## GUI test suggestions (left to you)
1. Verify the person list panel refreshes and shows all contacts after a filter (e.g., after `findperson`).
2. Verify the empty list message in the UI when no persons exist.
3. Ensure the UI switches to the persons tab (not orders) after `listperson`.
