package minefield;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class SouthWestCommand extends Command {

    public SouthWestCommand(Model model) {
        super(model);
    }

    public void execute() {
        Minefield field = (Minefield)model;
        try {
            field.moveSW();
        } catch (IllegalMoveException illegalMove) {
            Utilities.inform(illegalMove.getMessage());
        } catch (GameOverException gameOver) {
            Utilities.inform(gameOver.getMessage());
        }
    }
}
