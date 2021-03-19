package minefield;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class SouthEastCommand extends Command {

    public SouthEastCommand(Model model) {
        super(model);
    }

    public void execute() {
        Minefield field = (Minefield)model;
        try {
            field.moveSE();
        } catch (IllegalMoveException illegalMove) {
            Utilities.inform(illegalMove.getMessage());
        } catch (GameOverException gameOver) {
            Utilities.inform(gameOver.getMessage());
        }
    }
}
