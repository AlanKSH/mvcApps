package mvc;

import tools.Utilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/* AppPanel class contains a controlPanel and a view in two grid tiles.
Protected members can be accessed in child classes to enable customization.
 */
public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {
    protected View view;
    protected Model model;
    protected JFrame frame;
    protected AppFactory factory;
    protected JPanel controlPanel;
    public static int FRAME_WIDTH = 500;
    public static int FRAME_HEIGHT = 300;

    public AppPanel(AppFactory f){
        factory = f;
        model = factory.makeModel();
        view = factory.makeView(model);
        controlPanel = new JPanel();

        setLayout((new GridLayout(1, 2)));
        add(controlPanel);
        add(view);

        controlPanel.setBackground(Color.PINK);
        view.setBackground(Color.GRAY);
        frame = new JFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(createMenuBar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(factory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

    }
    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu =
                Utilities.makeMenu("File", new String[] {"New", "Save", "Save as", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu =
                Utilities.makeMenu("Edit", factory.getEditCommands(), this);
        result.add(editMenu);
        JMenu helpMenu =
                Utilities.makeMenu("Help", new String[] {"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmmd= e.getActionCommand();
        try {
            if (cmmd.equals("New")) {
                model = factory.makeModel();
                view.setModel(model);
            } else if (cmmd.equals("Save")) {
                save();
            } else if (cmmd.equals("Save as")) {
                saveAs();
            } else if (cmmd.equals("Open")) {
                String fName = Utilities.getFileName(model.getFileName(), true);
                if(!fName.isEmpty()) {
                    ObjectInputStream is = new ObjectInputStream((new FileInputStream((fName))));
                    model = (Model) is.readObject();
                    view.setModel(model);
                }
            } else if (cmmd.equals("Quit")) {
                // check for changes, if the model was changed, ask the user to save
                if(model.getChanged() && Utilities.confirm("Save changes before quitting?")){
                    save();
                }
                System.exit(1);
            } else if (cmmd.equals("Help")) {
                Utilities.inform(factory.getHelp());

            } else if (cmmd.equals("About")) {
                Utilities.inform(factory.about());

            } else { // Command is a custom edit command
                Command editCommand = factory.makeEditCommand(model, cmmd);
                editCommand.execute();
            }
        }catch(Exception ex) {
            handleException(ex);
        }
    }

    /* handleException method can be called while running commands.
    Prints an error message if an exception is thrown.
    This method may be overridden in the child class to enable special events for exceptions.
     */
    public void handleException(Exception e){
        Utilities.error(e);
    }

    // saveAs method saves by prompting the user to enter a file name
    public void saveAs() throws Exception{
        String fName = Utilities.getFileName(null, false);
        if(!fName.isEmpty()) {
            model.setFileName(fName);
            model.saved(); // set unsavedChanges to false before writing the object
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
            os.writeObject(model);
            os.close();
        }
    }

    /* save method attempts to save if the filename is already set,
    or it calls saveAs if not
     */
    public void save() throws Exception{
        if (model.getFileName() == null){
            saveAs();
        }else{
            model.saved();
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(model.getFileName()));
            os.writeObject(model);
            os.close();
        }
    }

    public void display(){ frame.setVisible(true); }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        view.repaint();
    }
}
