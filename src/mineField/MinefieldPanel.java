package mineField;
import mvc.*;
import tools.Utilities;

import javax.swing.*;
import java.awt.*;

public class MinefieldPanel extends AppPanel{
    public MinefieldPanel(AppFactory f) {
        super(f);

        FRAME_WIDTH = 900;
        FRAME_HEIGHT = 500;
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 1;
        c.weighty = 1;

        JButton northButton = new JButton("N");
        northButton.addActionListener(this);
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.PAGE_END;
        controlPanel.add(northButton, c);

        JButton southButton = new JButton("S");
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.PAGE_START;
        southButton.addActionListener(this);
        controlPanel.add(southButton, c);

        JButton westButton = new JButton("W");
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_END;
        westButton.addActionListener(this);
        controlPanel.add(westButton,c);

        JButton eastButton = new JButton("E");
        c.gridx = 2;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        eastButton.addActionListener(this);
        controlPanel.add(eastButton,c);

        JButton northEastButton = new JButton("NE");
        c.gridx = 2;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        northEastButton.addActionListener(this);
        controlPanel.add(northEastButton,c);

        JButton northWestButton = new JButton("NW");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        northWestButton.addActionListener(this);
        controlPanel.add(northWestButton,c);

        JButton southEastButton = new JButton("SE");
        c.gridx = 2;
        c.gridy = 2;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        southEastButton.addActionListener(this);
        controlPanel.add(southEastButton,c);

        JButton southWestButton = new JButton("SW");
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        southWestButton.addActionListener(this);
        controlPanel.add(southWestButton,c);
    }

    public void handleException(Exception e){
        Utilities.error(e);
    }

    public static void main(String[] args) {
        AppFactory factory = new MinefieldFactory();
        AppPanel panel = new MinefieldPanel(factory);
        panel.display();
    }

}
