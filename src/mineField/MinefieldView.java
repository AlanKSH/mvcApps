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
    private JLabel[][] labels;

    public MinefieldView(Model m) {
        super(m);
        mf = (Minefield) model;
        // Might need to use a constant for grid size instead, not sure
        labels = new JLabel[Minefield.WORLD_SIZE][Minefield.WORLD_SIZE];
        this.setLayout(new GridLayout(Minefield.WORLD_SIZE, Minefield.WORLD_SIZE));
        // j indicates column, i indicates row
        for(int j = 0; j < Minefield.WORLD_SIZE; j++) {
            for(int i = 0; i < Minefield.WORLD_SIZE; i++) {
                labels[i][j] = new JLabel("?");
                labels[i][j].setBorder(BLOCK_UNSEEN);
                this.add(labels[i][j]);
            }
        }
        labels[0][0].setBorder(BLOCK_CURRENT);
        labels[0][0].setText(Integer.toString(mf.getSurroundingMines()));
        // Set bottom right block to have a green border, since that is the goal the player must reach
        labels[Minefield.WORLD_SIZE - 1][Minefield.WORLD_SIZE - 1].setBorder(BLOCK_GOAL);
    }

    /* setModel method call model.setModel and redraws all the labels
     */
    public void setModel(Model m){
        super.setModel(m);
        mf = (Minefield) m;
        archiveX = 0;
        archiveY = 0;
        // Redraw all the blocks
        for(int j = 0; j < Minefield.WORLD_SIZE; j++) {
            for(int i = 0; i < Minefield.WORLD_SIZE; i++) {
                labels[i][j].setText("?");
                labels[i][j].setBorder(BLOCK_UNSEEN);
            }
        }
        // Draw the path
        for(Block b: mf.getPath()){
            labels[b.getXCoor()][b.getYCoor()].setText(String.valueOf(b.getSurroundingMines()));
            labels[b.getXCoor()][b.getYCoor()].setBorder(BLOCK_VISITED);
        }
        model.changed();
    }

    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        // Get the coordinates of the block occupied by the player
        int currentX = mf.getXpos();
        int currentY = mf.getYpos();

        // Debug printlns, these can be commented out or removed later
        System.out.println(currentX + ", " + currentY);
        System.out.println(mf.getSurroundingMines());

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