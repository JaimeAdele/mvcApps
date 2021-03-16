package minefield;

import mvc.*;

public class ChangeCommand extends Command {

    public ChangeCommand(Model model)
    {
        super(model);
    }

    public void execute() {
        MineField mineField = (MineField) model;
        mineField.change();
    }

}
