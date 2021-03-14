package mvc;

public abstract class Command {

    protected Model model;
    //test comment
    public Command(Model model) {
        super();
        this.model = model;
    }

    public String toString() {
        return "command.model = " + model;
    }

    public abstract void execute() throws Exception;
}
