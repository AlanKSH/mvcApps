package mineField;

import mvc.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MinefieldView extends View {
    private Minefield mf;
    private int archiveX;
    private int archiveY;
    private static Border BLOCK_UNSEEN = BorderFactory.createLineBorder(Color.BLACK);
    private static Border BLOCK_VISITED = BorderFactory.createLineBorder(Color.WHITE);
    private static Border BLOCK_CURRENT = BorderFactory.createLineBorder(Color.BLUE);
    private static Border BLOCK_GOAL = BorderFactory.createLineBorder(Color.GREEN);
    private static int WORLD_SIZE = 20;
    private JLabel[][] labels = new JLabel[WORLD_SIZE][WORLD_SIZE];;

    public MinefieldView(Model m) {
        super(m);
        mf = (Minefield) m;

        this.setLayout(new GridLayout(WORLD_SIZE, WORLD_SIZE));
        // Display 20 x 20 JLabels with black borders containing the text ?, to represent unseen blocks
        for(int i = 0; i < WORLD_SIZE; i++) {
            for(int j = 0; j < WORLD_SIZE; j++) {
                labels[i][j] = new JLabel("?");
                labels[i][j].setBorder(BLOCK_UNSEEN);
                // Add each JLabel to the GridLayout
                this.add(labels[i][j]);
            }
        }

        // Set top right block to have a current block's border color and number of surrounding mines by default, since it's the block that the player starts on
        labels[0][0].setBorder(BLOCK_CURRENT);
        labels[0][0].setText(Integer.toString(mf.getSurroundingMines()));
        // Set bottom right block to have a green border, since that is the goal the player must reach
        labels[WORLD_SIZE - 1][WORLD_SIZE - 1].setBorder(BLOCK_GOAL);
    }

    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        // Get the coordinates of the block occupied by the player
        int currentX = mf.location.getXCoor();
        int currentY = mf.location.getYCoor();

        // Debug printlns, these can be commented out or removed later
        System.out.println(currentX + ", " + currentY);
        System.out.println(mf.location.blockHasMine());

        // Modify the text and border color of the corresponding JLabel
        labels[currentX][currentY].setText(Integer.toString(mf.getSurroundingMines()));
        // Use blue to denote the block that the player is currently standing on
        labels[currentX][currentY].setBorder(BLOCK_CURRENT);

        // Use white to denote blocks that have already been visited, but are not the current block
        labels[archiveX][archiveY].setBorder(BLOCK_VISITED);
        // Keep a record of the last visited block's coordinates
        archiveX = currentX;
        archiveY = currentY;
    }
}
