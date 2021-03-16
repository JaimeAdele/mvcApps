package minefield;

import mvc.*;

public class NorthCommand extends Command {
    public NorthCommand(Model model) {
    super(model);
}

    public void execute() {
        Minefield field = (Minefield)model;
        field.moveN();
    }
}
