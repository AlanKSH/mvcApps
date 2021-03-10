import java.awt.Color;
import java.util.*;
import java.util.List;
import tools.*;
public class MineField extends Bean {    
    public static Integer WORLD_SIZE = 250;
    Block location;
    List<Block> path;
    boolean takenFlag;
    boolean checkMineFlag;
    private Heading direction;
    public MineField() {
        location = new Block(0,0);
        path = new LinkedList<Block>();
        takenFlag = true;
        checkMineFlag = false;
    }
    public void setLocation() {

    }

    public List<Block> getPath() {

    }
    
    public boolean setTakenFlag() {
        takenFlag = true;
        path.add(location);

        firePropertyChange(null, null, null);
    }

    private setMineFlag() {
        
    }
    private boolean isMineFlag() {
        return checkMineFlag;
    }

    public void move(int steps) {

    }
}