package minefield;

import mvc.Command;
import mvc.Model;
import mvc.View;
import mvc.*;

public class MinefieldFactory implements AppFactory{
    public Model makeModel() { return new Minefield(); }

    public View makeView(Model m) {
        return new MinefieldView((Minefield)m);
    }

    public String[] getEditCommands() { return new String[] {"N", "NW", "NE", "W", "E", "S",
            "SW", "SE"}; }

    public Command makeEditCommand(Model model, String type) {
        if (type == "N")
            return new NorthCommand(model);
        if (type == "NW")
            return new NorthWestCommand(model);
        if (type == "NE")
            return new NorthEastCommand(model);
        if (type == "W")
            return new WestCommand(model);
        if (type == "E")
            return new EastCommand(model);
        if (type == "S")
            return new SouthCommand(model);
        if (type == "SW")
            return new SouthWestCommand(model);
        if (type == "SE")
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
