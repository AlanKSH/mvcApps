package mineField;

import java.io.Serializable;
public class Block implements Serializable {
    int xCoor;
    int yCoor;
    private Boolean endPoint;

    public Block(int xCoor, int yCoor) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        endPoint = false;
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
}