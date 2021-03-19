package minefield;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class NorthEastCommand extends Command {

    public NorthEastCommand(Model model) {
        super(model);
    }

    public void execute() {
        Minefield field = (Minefield)model;
        try {
            field.moveNE();
        } catch (IllegalMoveException illegalMove) {
            Utilities.inform(illegalMove.getMessage());
        } catch (GameOverException gameOver) {
            Utilities.inform(gameOver.getMessage());
        }
    }
}
