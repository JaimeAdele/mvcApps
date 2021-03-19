package minefield;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class WestCommand extends Command {
    public WestCommand(Model model) {
        super(model);
    }

    public void execute() {
        Minefield field = (Minefield)model;
        try {
            field.moveW();
        } catch (IllegalMoveException illegalMove) {
            Utilities.inform(illegalMove.getMessage());
        } catch (GameOverException gameOver) {
            Utilities.inform(gameOver.getMessage());
        }
    }
}
