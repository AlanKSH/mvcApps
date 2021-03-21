package mvc;

import tools.Bean;

abstract public class Model extends Bean {
    private boolean unsavedChanges = false;
    private String fileName = null;

    public boolean getChanged(){ return unsavedChanges; }
    public String getFileName() { return fileName; }
    public void setFileName(String name){
        fileName = name;
    }

    public void saved(){
        unsavedChanges = false;
    }

    public void changed(){
        // Fire a generic property change for the model
        firePropertyChange("Property",null,this);
        unsavedChanges = true;
    }
}
