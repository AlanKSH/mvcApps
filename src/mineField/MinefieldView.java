package mineField;

import mvc.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MinefieldView extends View {
    private MineField mf;
    private static int GRID_SIZE = 20;
    private JLabel[][] labels;

    public MinefieldView(Model m) {
        super(m);
        mf = new MineField();
        labels = new JLabel[GRID_SIZE][GRID_SIZE];

        // Might need to use a constant for grid size instead, not sure
        this.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        // Display n x n JLabels containing the text ?

        for(int i = 0; i < GRID_SIZE; i++) {
            for(int j = 0; j < GRID_SIZE; j++) {
                labels[i][j] = new JLabel("?");
                this.add(labels[i][j]);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        super.propertyChange(arg0);
        // Locate the patch occupied by the player
        int currentX = mf.location.getXCoor();
        int currentY = mf.location.getYCoor();
        // Modify the label, border, and/or background color of the corresponding JLabel
        labels[currentX][currentY] = new JLabel(""+mf.numsOfMine());
        Border greenLine = BorderFactory.createLineBorder(Color.GREEN);
        labels[currentX][currentY].setBorder(greenLine);
    }
}
