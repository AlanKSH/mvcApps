package mineField;
import java.io.Serializable;
import java.util.*;
public class Block implements Serializable {
    int xCoor;
    int yCoor;
    private Boolean hasMine;
    private Boolean endPoint;

    public Block(int xCoor, int yCoor) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        endPoint = false;
        Random rand = new Random();
        hasMine = rand.nextBoolean();
    }
    public void setX(int xCoor) {
        this.xCoor = xCoor;
    }
    public void setY(int yCoor) {
        this.yCoor = yCoor;
    }
    public int getXCoor() {
        return xCoor;
    }
    public int getYCoor() {
        return yCoor;
    }
    public Boolean getEndPoint() {
        return endPoint;
    }
    public void setEndPoint(Boolean endPoint) {
        this.endPoint = endPoint;
    }

    public Boolean blockHasMine() {
        return hasMine;
    }
}
