package mineField;

import mvc.*;

public class MinefieldCommand extends Command {
    Heading heading;

    public MinefieldCommand(Model model) {
        super(model);
    }

    public void execute() {
        MineField minefield = (MineField) model;
        //minefield.change();
        minefield.move();
    }
}
