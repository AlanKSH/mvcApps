package mineField;
import java.io.Serializable;
import java.util.*;
// Custom class for Minefield tiles that stores information about each tile
// Information includes a tile's coordinates, the number of mines in surrounding tiles, and if the tile has a mine/is an endpoint
public class Block implements Serializable {
    public static int percentMined = 10;
    int xCoor;
    int yCoor;
    private Boolean hasMine;
    private Boolean endPoint;
    private int surroundingMines;

    public Block(int xCoor, int yCoor) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        endPoint = false;
        if(Math.random()> (double) percentMined / 100){
            hasMine = false;
        }
        else{
            hasMine = true;
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
