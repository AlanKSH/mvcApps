package mineField;

import mvc.*;

public class MinefieldCommand extends Command {
    Heading heading;
    public MinefieldCommand(Model model, Heading h) {
        super(model);
        heading = h;
    }

    public void execute() {

    }
}
