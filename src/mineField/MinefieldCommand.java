package mineField;

import mvc.*;

public class MinefieldCommand extends Command {
    Heading heading;
    public MinefieldCommand(Model model, Heading h) {
        super(model);
        heading = h;
    }

    /* execute method sets the heading of the model, and moves it
    throws exceptions in case move() moves onto a mine or wins
     */
    public void execute() throws Exception{
        Minefield minefield = (Minefield) model;
        minefield.turn(heading);
        minefield.move();

    }
}

