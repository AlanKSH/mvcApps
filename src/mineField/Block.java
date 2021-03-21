package mineField;
import java.io.Serializable;
import java.util.*;
public class Block implements Serializable {
    int xCoor;
    int yCoor;
    private Boolean hasMine;
    private Boolean endPoint;
    private int surroundingMines;

    public Block(int xCoor, int yCoor) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        endPoint = false;
        if(Math.random()>.9){
            hasMine = true;
        }
        else{
            hasMine = false;
        }
    }
    public void setX(int xCoor) {
        this.xCoor = xCoor;
    }
    public void setY(int yCoor) {
        this.yCoor = yCoor;
    }
    public void setSurroundingMines(int mines){ surroundingMines = mines; }
    public int getSurroundingMines(){ return surroundingMines; }
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
