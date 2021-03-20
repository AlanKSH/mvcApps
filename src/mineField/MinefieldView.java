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
    private static int WORLD_SIZE = 20;
    private JLabel[][] labels = new JLabel[WORLD_SIZE][WORLD_SIZE];;

    public MinefieldView(Model m) {
        super(m);
        mf = (Minefield) model;
        // Might need to use a constant for grid size instead, not sure
        this.setLayout(new GridLayout(WORLD_SIZE, WORLD_SIZE));
        // Display n x n JLabels containing the text ?
        for(int j = 0; j < WORLD_SIZE; j++) {
            for(int i = 0; i < WORLD_SIZE; i++) {
                labels[i][j] = new JLabel("?");
                labels[i][j].setBorder(BLOCK_UNSEEN);
                this.add(labels[i][j]);
            }
        }
        model.changed();
    }

    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        // Locate the patch occupied by the player
        int currentX = mf.getXpos();
        int currentY = mf.getYpos();

        // Modify the label, border, and/or background color of the corresponding JLabel
        labels[currentX][currentY].setText(String.valueOf(mf.getSurroundingMines()));
        labels[currentX][currentY].setBorder(BLOCK_VISITED);
        repaint();
    }
}