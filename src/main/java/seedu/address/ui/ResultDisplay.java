package seedu.address.ui;

import static java.util.Objects.requireNonNull;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

/**
 * A ui for the status bar that is displayed at the header of the application.
 */
public class ResultDisplay extends UiPart<Region> {

    private static final String FXML = "ResultDisplay.fxml";

    @FXML
    private Label resultDisplay;

    /**
     * Creates a {@code ResultDisplay}.
     */
    public ResultDisplay() {
        super(FXML);

        // Keep message wrapping in sync with the container width so height can grow correctly.
        resultDisplay.prefWidthProperty().bind(Bindings.max(0, getRoot().widthProperty().subtract(24)));
        resultDisplay.setMinHeight(Region.USE_PREF_SIZE);
    }

    /**
     * Sets the feedback message shown to the user.
     */
    public void setFeedbackToUser(String feedbackToUser) {
        requireNonNull(feedbackToUser);
        resultDisplay.setText(feedbackToUser);
        resultDisplay.requestLayout();
        getRoot().requestLayout();
    }

}
