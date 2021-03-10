package mineField;
import mvc.*;

import javax.swing.*;
import java.awt.*;

public class MinefieldPanel extends AppPanel{
    public MinefieldPanel(AppFactory f) {
        super(f);
        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.1;
        c.weighty = 0.1;

        JButton northButton = new JButton("N");
        northButton.addActionListener(this);
        c.gridx = 1;
        c.gridy = 0;
        controlPanel.add(northButton, c);

        JButton southButton = new JButton("S");
        c.gridx = 1;
        c.gridy = 2;
        southButton.addActionListener(this);
        controlPanel.add(southButton, c);

        JButton westButton = new JButton("W");
        c.gridx = 0;
        c.gridy = 1;
        westButton.addActionListener(this);
        controlPanel.add(westButton,c);

        JButton eastButton = new JButton("E");
        c.gridx = 2;
        c.gridy = 1;
        eastButton.addActionListener(this);
        controlPanel.add(eastButton,c);

        JButton northEastButton = new JButton("NE");
        c.gridx = 2;
        c.gridy = 0;
        eastButton.addActionListener(this);
        controlPanel.add(northEastButton,c);

        JButton northWestButton = new JButton("NW");
        c.gridx = 0;
        c.gridy = 0;
        eastButton.addActionListener(this);
        controlPanel.add(northWestButton,c);

        JButton southEastButton = new JButton("SE");
        c.gridx = 2;
        c.gridy = 2;
        eastButton.addActionListener(this);
        controlPanel.add(southEastButton,c);

        JButton southWestButton = new JButton("SW");
        c.gridx = 0;
        c.gridy = 2;
        eastButton.addActionListener(this);
        controlPanel.add(southWestButton,c);
    }
    public static void main(String[] args) {
        AppFactory factory = new MinefieldFactory();
        AppPanel panel = new MinefieldPanel(factory);
        panel.display();
    }

}
