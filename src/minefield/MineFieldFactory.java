package minefield;

import mvc.Command;
import mvc.Model;
import mvc.View;
import mvc.*;

public class MineFieldFactory implements AppFactory{
    public Model makeModel() { return new Minefield(); }

    public View makeView(Model m) {
        return new MineFieldView((Minefield)m);
    }

    public String[] getEditCommands() { return new String[] {"North", "Northwest", "Northeast", "West", "East", "South", "Southwest", "Southeast"}; }

    public Command makeEditCommand(Model model, String type) {
        if (type == "North")
            return new NorthCommand(model);
        if (type == "Northwest")
            return new NorthWestCommand(model);
        if (type == "Northeast")
            return new NorthEastCommand(model);
        if (type == "West")
            return new WestCommand(model);
        if (type == "East")
            return new EastCommand(model);
        if (type == "South")
            return new SouthCommand(model);
        if (type == "Southwest")
            return new SouthWestCommand(model);
        if (type == "Southeast")
            return new SouthEastCommand(model);
        return null;
    }

    public String getTitle() { return "Minefield"; }

    public String[] getHelp() {
        return new String[] {"Click a direction to move a space in the respective direction."};
    }

    public String about() {
        return "Minefield version 1.0. Copyright 2021 by Deven Shah, Ekta Halani, and Jaime Zuspann";
    }
}
