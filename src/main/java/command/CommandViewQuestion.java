package command;

import static constants.ErrorMessages.VIEW_INVALID_INDEX;
import static flashcard.types.FlashcardList.viewFlashcardQuestion;

import ui.Ui;

/**
 * Class that handles viewing of the question of the flashcard
 */
public class CommandViewQuestion extends Command{
    private final String arguments;
    public CommandViewQuestion(String arguments) {
        this.arguments = arguments;
    }

    /**
     * executes the command to view the question.
     */
    public void executeCommand() {
        try {
            int index = Integer.parseInt(arguments);
            Ui.showToUser(viewFlashcardQuestion(index));
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.showError(e.getMessage());
        } catch (NumberFormatException e) {
            Ui.showError(VIEW_INVALID_INDEX);
        }
    }
}
