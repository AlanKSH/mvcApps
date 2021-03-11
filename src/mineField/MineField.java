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
        location = currentBlock;
    }

    public List<Block> getPath() {
        return path;
    }
    
    public boolean setTakenFlag() {
        takenFlag = true;
        path.add(location);

        firePropertyChange(null, null, null);
    }

    private setMineFlag() {
        Random rd = new Random();
        checkMineFlag = rd.nextBoolean();
    }
    private boolean isMineFlag() {
        if (checkMineFlag == true)
            return true;
        else return false;
    }
    public List<Block> getPredictedBlocks(Block b) {
        
    }
    
    public void move(int steps) {

    }
}
