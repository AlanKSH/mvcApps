package tools;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;

public class Utilities {

    // asks user a yes/no question
    public static boolean confirm(String query) {
        int result = JOptionPane.showConfirmDialog(null,
                query, "choose one", JOptionPane.YES_NO_OPTION);
        return result == 0;
    }

    // asks user for info
    public static String ask(String query) {
        return JOptionPane.showInputDialog(null, query);
    }

    // tells user some info
    public static void inform(String info) {
        JOptionPane.showMessageDialog(null,info);
    }

    // tells user a lot of info
    public static void inform(String[] items) {
        String helpString = "";
        for(int i = 0; i < items.length; i++) {
            helpString = helpString + "\n" + items[i];
        }
        inform(helpString);
    }

    // tells user about an error
    public static void error(String gripe) {
        JOptionPane.showMessageDialog(null,
                gripe,
                "OOPS!",
                JOptionPane.ERROR_MESSAGE);
    }

    // tells user about an exception
    public static void error(Exception gripe) {
        gripe.printStackTrace();
        JOptionPane.showMessageDialog(null,
                gripe.getMessage(),
                "OOPS!",
                JOptionPane.ERROR_MESSAGE);
    }

    // simple menu maker
    public static JMenu makeMenu(String name, String[] items, ActionListener handler) {
        JMenu result = new JMenu(name);
        for(int i = 0; i < items.length; i++) {
            JMenuItem item = new JMenuItem(items[i]);
            item.addActionListener(handler);
            result.add(item);
        }
        return result;
    }

    /* Method asks the user for a file name and returns the string
    Parameters: String fName which is used for the open chooser directory, Boolean open
    Returns: The string for the file, or an empty string if the user cancels
     */
    public static String getFileName(String fName, Boolean open) {
        JFileChooser chooser = new JFileChooser();
        String result = null;
        if (fName != null) {
            // open chooser in directory of fName
            chooser.setCurrentDirectory(new File(fName));
        }
        int returnVal;
        if (open) {
            returnVal = chooser.showOpenDialog(null);
        } else {
            returnVal = chooser.showSaveDialog(null);
        }
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            result= chooser.getSelectedFile().getPath();
        } else if(returnVal == JFileChooser.CANCEL_OPTION){
            return "";
        }
        return result;
    }

}

