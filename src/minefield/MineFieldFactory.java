package minefield;

import mvc.*;

public class MineFieldFactory implements AppFactory {

    public Model makeModel() { return new MineField(); }

    public View makeView(Model m) {
        return new MineFieldView((MineField) m);
    }

    public String[] getEditCommands() { return new String[] {"Change"}; }

    public Command makeEditCommand(Model model, String type) {
        if (type == "Change")
            return new ChangeCommand(model);
        return null;
    }

    public String getTitle() { return "Stop Light Simulator"; }

    public String[] getHelp() {
        return new String[] {"click Change to cycle through colors"};
    }

    public String about() {
        return "MineField version 1.0. Copyright 2021 by CS151 Team 8";
    }

}
