package mineField;

import mvc.*;

public class MinefieldCommand extends Command {
    Heading heading;
    public MinefieldCommand(Model model, Heading h) {
        super(model);
        heading = h;
    }

    // Executes a generated command from the class extending AppFactory
    public void execute() {
        Minefield minefield = (Minefield) model;
        // Change the direction in which the player will move one step
        minefield.turn(heading);
        // Prompt the player to move one step forward
        minefield.move();
    }
}
