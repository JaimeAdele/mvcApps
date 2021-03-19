package minefield;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class SouthCommand extends Command {
    public SouthCommand(Model model) {
        super(model);
    }

    public void execute() {
        Minefield field = (Minefield)model;
        try {
            field.moveS();
        } catch (IllegalMoveException illegalMove) {
            Utilities.inform(illegalMove.getMessage());
        } catch (GameOverException gameOver) {
            Utilities.inform(gameOver.getMessage());
        }
    }
}
