package mineField;

import java.awt.Color;
import java.lang.invoke.WrongMethodTypeException;
import java.util.*;
import java.util.List;
import tools.*;
import mvc.*;

public class Minefield extends Model {
    public static Integer WORLD_SIZE = 20;
    int x,y;
    List<Block> path;
    boolean takenFlag;
    boolean checkMineFlag;
    private Heading direction;
    Block [][] boardArray = new Block[WORLD_SIZE][WORLD_SIZE];

    public Minefield() {
        x = y = 0;
        for (int i = 0; i <WORLD_SIZE; i++)
        {
            for (int j = 0; j <WORLD_SIZE; j++)
            {
                boardArray[i][j]=new Block(i, j);
            }
        }
        path = new LinkedList<Block>();
        takenFlag = true;
        checkMineFlag = false;
    }

    public List<Block> getPath() {
        return path;
    }
    
    public void setTakenFlag() {
        takenFlag = true;
        path.add(boardArray[x][y]);

        firePropertyChange(null, null, null);
    }

    private void setMineFlag() {
        Random rd = new Random();
        checkMineFlag = rd.nextBoolean();
    }
    private boolean isMineFlag() {
        if (checkMineFlag == true)
            return true;
        else return false;
    }

    public int getYpos(){
        return y;
    }

    public int getXpos(){
        return x;
    }

    public int getSurroundingMines() {
        int count = 0;
        List<Block> tempList = new LinkedList<Block>();
        if(x!=0){
            tempList.add(boardArray[x-1][y]);
        }
        if(y!=0){
            tempList.add(boardArray[x][y-1]);
        }
        if(x!=WORLD_SIZE-1){
            tempList.add(boardArray[x+1][y]);
        }
        if(y!=WORLD_SIZE-1){
            tempList.add(boardArray[x][y+1]);
        }
        if(x!=0 &&y!=0){
            tempList.add(boardArray[x-1][y-1]);
        }
        if(x!= 0 && y!=WORLD_SIZE-1){
            tempList.add(boardArray[x-1][y+1]);
        }
        if(x!= WORLD_SIZE-1 && y!=0){
            tempList.add(boardArray[x+1][y-1]);
        }
        if(x!= WORLD_SIZE-1 && y!= WORLD_SIZE-1){
            tempList.add(boardArray[x+1][y+1]);
        }

        for (Block x : tempList) {
            if (x.blockHasMine() == true) count++;
        }
        return count;
    }

    /*public List<Block> getPredictedBlocks() {
        List<Block> listBlock = new LinkedList<Block>();
        List<Block> tempList = new LinkedList<Block>();
        if ((x ==0)&& (y == 0)) {
            Block b1 = new Block(x, y + 1);
            Block b2 = new Block(x +1, y);
            Block b3 = new Block(x + 1, y + 1);
            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            
        }
        else if (x == 0) {
            Block b1 = new Block(x, y - 1);
            Block b2 = new Block(x +1, y - 1);
            Block b3 = new Block(x + 1, y);
            Block b4 = new Block(x + 1, y + 1);
            Block b5 = new Block(x, y + 1);

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            tempList.add(b4);
            tempList.add(b5);
        }
        else if (y == 0) {
            Block b1 = new Block(x - 1, location.yCoor());
            Block b2 = new Block(x - 1, location.yCoor() + 1);
            Block b3 = new Block(x, location.yCoor() + 1);
            Block b4 = new Block(x + 1, location.yCoor() + 1);
            Block b5 = new Block(x + 1 , location.yCoor());

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            tempList.add(b4);
            tempList.add(b5);
        }
        else if ((x == WORLD_SIZE - 1) && (y == 0)) {
            Block b1 = new Block(x - 1, location.yCoor());
            Block b2 = new Block(x - 1, location.yCoor() + 1);
            Block b3 = new Block(x, location.yCoor() + 1);

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
        }
        else if (x == WORLD_SIZE - 1) {
            Block b1 = new Block(x, location.yCoor() - 1);
            Block b2 = new Block(x - 1, location.yCoor() - 1);
            Block b3 = new Block(x - 1, location.yCoor());
            Block b4 = new Block(x - 1, location.yCoor() + 1);
            Block b5 = new Block(x, location.yCoor() + 1);

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            tempList.add(b4);
            tempList.add(b5);
        }
        else if ((y == WORLD_SIZE - 1) && (x == 0)) {
            Block b1 = new Block(x, location.yCoor() - 1);
            Block b2 = new Block(x + 1, location.yCoor() - 1);
            Block b3 = new Block(x + 1, location.yCoor());

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
        }

        else if (y == WORLD_SIZE - 1) {
            Block b1 = new Block(x, location.yCoor() - 1);
            Block b2 = new Block(x + 1, location.yCoor() - 1);
            Block b3 = new Block(x + 1, location.yCoor());
            Block b4 = new Block(x + 1, location.yCoor() + 1);
            Block b5 = new Block(x, location.yCoor() + 1);

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            tempList.add(b4);
            tempList.add(b5);
        }

        else {
            Block b1 = new Block(x - 1, y);
            Block b2 = new Block(x - 1, y + 1);
            Block b3 = new Block(x, y + 1);
            Block b4 = new Block(x + 1, y + 1);
            Block b5 = new Block(x + 1, y);
            Block b6 = new Block(x - 1, y - 1);
            Block b7 = new Block(x, y - 1);
            Block b8 = new Block(x + 1, y - 1);

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            tempList.add(b4);
            tempList.add(b5);
            tempList.add(b6);
            tempList.add(b7);
            tempList.add(b8);
        }
        for (Block x : tempList) {
            if (path.contains(x)) continue;
            else listBlock.add(x);
        }

        return listBlock;
    }*/

    public boolean checkGetMined() {
        if (path.get(path.size() - 1).blockHasMine() == true){
            return true;
            //System.out.println("Game Over!!!");
        }
        else return false;

    }
    public boolean checkGetHome() {
        if ((x == WORLD_SIZE - 1) && 
        (y == WORLD_SIZE - 1)) {
            return true;
            //win game!!!!
        }
        else return false;

    }
    public void move() {
        if (direction == Heading.NORTH) {
            y--;
        }

        if (direction == Heading.SOUTH) {
            y++;
        }

        if (direction == Heading.EAST) {
            x++;
        }

        if (direction == Heading.WEST) {
            x--;
        }

        if (direction == Heading.NORTH_WEST) {
            x--;
            y--;
        }

        if (direction == Heading.NORTH_EAST) {
            x++;
            y--;
        }

        if (direction == Heading.SOUTH_WEST) {
            x--;
            y++;
        }

        if (direction == Heading.SOUTH_EAST) {
            x++;
            y++;
        }
        if (x >= WORLD_SIZE ){
            x--;
        }
        else if(x<0){
            x++;
        }
        if (y >= WORLD_SIZE ){
            y--;
        }
        else if(y<0){
            y++;
        }
        changed();
    } 

    public void turn(Heading direction) {
        this.direction = direction;
    }

    /*public int numsOfMine() {
        int count = 0;
        List<Block> tempMineList = getPredictedBlocks();
        for (int i = 0; i < tempMineList.size(); i++) {
            if (tempMineList.get(i).blockHasMine() == true) count++;
        }
        return count;
    }*/
}
