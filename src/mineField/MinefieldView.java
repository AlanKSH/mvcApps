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
        model.changed();
    }

    /* setModel method call model.setModel and redraws all the labels
    Currently does not draw visited tiles when opening a model
     */
    public void setModel(Model m){
        super.setModel(m);
        mf = (Minefield) m;
        for(int j = 0; j < Minefield.WORLD_SIZE; j++) {
            for(int i = 0; i < Minefield.WORLD_SIZE; i++) {
                labels[i][j].setText("?");
                labels[i][j].setBorder(BLOCK_UNSEEN);
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
    }
}