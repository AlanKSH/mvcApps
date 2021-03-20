package mineField;

import mvc.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MinefieldView extends View {
    private Minefield mf;
    private static Border BLOCK_UNSEEN = BorderFactory.createLineBorder(Color.BLACK);
    private static Border BLOCK_VISITED = BorderFactory.createLineBorder(Color.WHITE);
    private static Border BLOCK_GOAL = BorderFactory.createLineBorder(Color.GREEN);
    private static int WORLD_SIZE = 20;
    private JLabel[][] labels = new JLabel[WORLD_SIZE][WORLD_SIZE];;

    public MinefieldView(Model m) {
        super(m);
        mf = (Minefield) m;

        this.setLayout(new GridLayout(WORLD_SIZE, WORLD_SIZE));
        // Display n x n JLabels containing the text ?
        for(int i = 0; i < WORLD_SIZE; i++) {
            for(int j = 0; j < WORLD_SIZE; j++) {
                labels[i][j] = new JLabel("?");
                labels[i][j].setBorder(BLOCK_UNSEEN);
                this.add(labels[i][j]);
            }
        }

        // Set top right block as already visited, since it's the block that the player starts on
        labels[0][0].setBorder(BLOCK_VISITED);
        labels[0][0].setText(Integer.toString(mf.getSurroundingMines()));
        // Set bottom right block to have a green border, since that is the goal the player must reach
        labels[WORLD_SIZE - 1][WORLD_SIZE - 1].setBorder(BLOCK_GOAL);
    }

    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        // Locate the patch occupied by the player
        int currentX = mf.location.getXCoor();
        int currentY = mf.location.getYCoor();

        System.out.println(currentX + ", " + currentY);

        // Modify the label, border, and/or background color of the corresponding JLabel
        labels[currentX][currentY].setText(Integer.toString(mf.getSurroundingMines()));
        labels[currentX][currentY].setBorder(BLOCK_VISITED);
    }
}
