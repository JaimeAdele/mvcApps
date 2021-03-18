package minefield;

import mvc.*;

public class NorthCommand extends Command {
    public NorthCommand(Model model) {
    super(model);
}

    public void execute() {
        Minefield field = (Minefield)model;
        try {
            field.moveN();
        } catch (IllegalMoveException illegalMove) {
            Utilities.inform(illegalMove.getMessage());
        } catch (GameOverException gameOver) {
            Utilities.inform(gameOver.getMessage());
        }
    }
}
