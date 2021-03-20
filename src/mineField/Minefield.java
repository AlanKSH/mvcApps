package mineField;

import java.awt.Color;
import java.util.*;
import java.util.List;
import tools.*;
import mvc.*;

public class Minefield extends Model {
    public static Integer WORLD_SIZE = 20;
    Block location;
    List<Block> path;
    boolean takenFlag;
    boolean checkMineFlag;
    private Heading direction;
    Block [][] boardArray = new Block[WORLD_SIZE][WORLD_SIZE];

    public Minefield() {
        for (int i = 0; i <WORLD_SIZE; i++)
        {
            for (int j = 0; j <WORLD_SIZE; j++)
            {
                boardArray[i][j]=new Block(i, j);
            }
        }
        location = boardArray[0][0];
        path = new LinkedList<Block>();
        takenFlag = true;
        checkMineFlag = false;
    }
    public void setLocation(Block currentBlock) {
        location = currentBlock;
    }

    public List<Block> getPath() {
        return path;
    }
    
    public void setTakenFlag() {
        takenFlag = true;
        path.add(location);

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

    public int getSurroundingMines() {
        int count = 0;
        List<Block> tempList = new LinkedList<Block>();
        if ((location.getXCoor() ==0)&& (location.getYCoor() == 0)) {
            Block b1 = boardArray[location.getXCoor()][location.getYCoor() + 1];
            Block b2 = boardArray[location.getXCoor() +1][location.getYCoor()];
            Block b3 = boardArray[location.getXCoor() + 1][location.getYCoor() + 1];
            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);


        }
        else if (location.getXCoor() == 0) {
            Block b1 = boardArray[location.getXCoor()][location.getYCoor() - 1];
            Block b2 = boardArray[location.getXCoor() +1][location.getYCoor() - 1];
            Block b3 = boardArray[location.getXCoor() + 1][location.getYCoor()];
            Block b4 = boardArray[location.getXCoor() + 1][location.getYCoor() + 1];
            Block b5 = boardArray[location.getXCoor()][location.getYCoor() + 1];

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            tempList.add(b4);
            tempList.add(b5);
        }
        else if (location.getYCoor() == 0) {
            Block b1 = boardArray[location.getXCoor() - 1][location.getYCoor()];
            Block b2 = boardArray[location.getXCoor() - 1][location.getYCoor() + 1];
            Block b3 = boardArray[location.getXCoor()][location.getYCoor() + 1];
            Block b4 = boardArray[location.getXCoor() + 1][location.getYCoor() + 1];
            Block b5 = boardArray[location.getXCoor() + 1][location.getYCoor()];

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            tempList.add(b4);
            tempList.add(b5);
        }
        else if ((location.getXCoor() == WORLD_SIZE - 1) && (location.getYCoor() == 0)) {
            Block b1 = boardArray[location.getXCoor() - 1][location.getYCoor()];
            Block b2 = boardArray[location.getXCoor() - 1][location.getYCoor() + 1];
            Block b3 = boardArray[location.getXCoor()][location.getYCoor() + 1];

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
        }
        else if (location.getXCoor() == WORLD_SIZE - 1) {
            Block b1 = boardArray[location.getXCoor()][location.getYCoor() - 1];
            Block b2 = boardArray[location.getXCoor() - 1][location.getYCoor() - 1];
            Block b3 = boardArray[location.getXCoor() - 1][location.getYCoor()];
            Block b4 = boardArray[location.getXCoor() - 1][location.getYCoor() + 1];
            Block b5 = boardArray[location.getXCoor()][location.getYCoor() + 1];

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            tempList.add(b4);
            tempList.add(b5);
        }
        else if ((location.getYCoor() == WORLD_SIZE - 1) && (location.getXCoor() == 0)) {
            Block b1 = boardArray[location.getXCoor()][location.getYCoor() - 1];
            Block b2 = boardArray[location.getXCoor() + 1][location.getYCoor() - 1];
            Block b3 = boardArray[location.getXCoor() + 1][location.getYCoor()];

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
        }

        else if (location.getYCoor() == WORLD_SIZE - 1) {
            Block b1 = boardArray[location.getXCoor()][location.getYCoor() - 1];
            Block b2 = boardArray[location.getXCoor() + 1][location.getYCoor() - 1];
            Block b3 = boardArray[location.getXCoor() + 1][location.getYCoor()];
            Block b4 = boardArray[location.getXCoor() + 1][location.getYCoor() + 1];
            Block b5 = boardArray[location.getXCoor()][location.getYCoor() + 1];

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            tempList.add(b4);
            tempList.add(b5);
        }

        else {
            Block b1 = boardArray[location.getXCoor() - 1][location.getYCoor()];
            Block b2 = boardArray[location.getXCoor() - 1][location.getYCoor() + 1];
            Block b3 = boardArray[location.getXCoor()][location.getYCoor() + 1];
            Block b4 = boardArray[location.getXCoor() + 1][location.getYCoor() + 1];
            Block b5 = boardArray[location.getXCoor() + 1][location.getYCoor()];
            Block b6 = boardArray[location.getXCoor() - 1][location.getYCoor() - 1];
            Block b7 = boardArray[location.getXCoor()][location.getYCoor() - 1];
            Block b8 = boardArray[location.getXCoor() + 1][location.getYCoor() - 1];

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
            if (x.blockHasMine() == true) count++;
        }
        return count;
    }

    /*public List<Block> getPredictedBlocks() {
        List<Block> listBlock = new LinkedList<Block>();
        List<Block> tempList = new LinkedList<Block>();
        if ((location.getXCoor() ==0)&& (location.getYCoor() == 0)) {
            Block b1 = new Block(location.getXCoor(), location.getYCoor() + 1);
            Block b2 = new Block(location.getXcoor() +1, location.getYCoor());
            Block b3 = new Block(location.getXCoor() + 1, location.getYCoor() + 1);
            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            
        }
        else if (location.getXCoor() == 0) {
            Block b1 = new Block(location.getXCoor(), location.getYCoor() - 1);
            Block b2 = new Block(location.getXcoor() +1, location.getYCoor() - 1);
            Block b3 = new Block(location.getXCoor() + 1, location.getYCoor());
            Block b4 = new Block(location.getXCoor() + 1, location.getYCoor() + 1);
            Block b5 = new Block(location.getXCoor(), location.getYCoor() + 1);

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            tempList.add(b4);
            tempList.add(b5);
        }
        else if (location.getYCoor() == 0) {
            Block b1 = new Block(location.getXCoor() - 1, location.yCoor());
            Block b2 = new Block(location.getXcoor() - 1, location.yCoor() + 1);
            Block b3 = new Block(location.getXCoor(), location.yCoor() + 1);
            Block b4 = new Block(location.getXCoor() + 1, location.yCoor() + 1);
            Block b5 = new Block(location.getXCoor() + 1 , location.yCoor());

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            tempList.add(b4);
            tempList.add(b5);
        }
        else if ((location.getXcoor() == WORLD_SIZE - 1) && (location.getYcoor() == 0)) {
            Block b1 = new Block(location.getXCoor() - 1, location.yCoor());
            Block b2 = new Block(location.getXcoor() - 1, location.yCoor() + 1);
            Block b3 = new Block(location.getXCoor(), location.yCoor() + 1);

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
        }
        else if (location.getXcoor() == WORLD_SIZE - 1) {
            Block b1 = new Block(location.getXCoor(), location.yCoor() - 1);
            Block b2 = new Block(location.getXcoor() - 1, location.yCoor() - 1);
            Block b3 = new Block(location.getXCoor() - 1, location.yCoor());
            Block b4 = new Block(location.getXCoor() - 1, location.yCoor() + 1);
            Block b5 = new Block(location.getXCoor(), location.yCoor() + 1);

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            tempList.add(b4);
            tempList.add(b5);
        }
        else if ((location.getYcoor() == WORLD_SIZE - 1) && (location.getXcoor() == 0)) {
            Block b1 = new Block(location.getXCoor(), location.yCoor() - 1);
            Block b2 = new Block(location.getXcoor() + 1, location.yCoor() - 1);
            Block b3 = new Block(location.getXCoor() + 1, location.yCoor());

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
        }

        else if (location.getYcoor() == WORLD_SIZE - 1) {
            Block b1 = new Block(location.getXCoor(), location.yCoor() - 1);
            Block b2 = new Block(location.getXcoor() + 1, location.yCoor() - 1);
            Block b3 = new Block(location.getXCoor() + 1, location.yCoor());
            Block b4 = new Block(location.getXCoor() + 1, location.yCoor() + 1);
            Block b5 = new Block(location.getXCoor(), location.yCoor() + 1);

            tempList.add(b1);
            tempList.add(b2);
            tempList.add(b3);
            tempList.add(b4);
            tempList.add(b5);
        }

        else {
            Block b1 = new Block(location.getXCoor() - 1, location.getYCoor());
            Block b2 = new Block(location.getXCoor() - 1, location.getYCoor() + 1);
            Block b3 = new Block(location.getXCoor(), location.getYCoor() + 1);
            Block b4 = new Block(location.getXCoor() + 1, location.getYCoor() + 1);
            Block b5 = new Block(location.getXCoor() + 1, location.getYCoor());
            Block b6 = new Block(location.getXCoor() - 1, location.getYCoor() - 1);
            Block b7 = new Block(location.getXCoor(), location.getYCoor() - 1);
            Block b8 = new Block(location.getXCoor() + 1, location.getYCoor() - 1);

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
        if ((location.getXCoor() == WORLD_SIZE - 1) && 
        (location.getYCoor() == WORLD_SIZE - 1)) {
            return true;
            //win game!!!!
        }
        else return false;

    }
    public void move() {
        Block tempBlock = null;
        if (direction == Heading.NORTH) {
            Block newMove = new Block(location.getXCoor(), location.getYCoor() - 1);
            path.add(location);
            location = newMove;
        }

        if (direction == Heading.SOUTH) {
            Block newMove = new Block(location.getXCoor(), location.getYCoor() + 1);
            path.add(location);
            location = newMove;
        }

        if (direction == Heading.EAST) {
            Block newMove = new Block(location.getXCoor() + 1, location.getYCoor());
            path.add(location);
            location = newMove;
        }

        if (direction == Heading.WEST) {
            Block newMove = new Block(location.getXCoor() - 1, location.getYCoor());
            path.add(location);
            location = newMove;
        }

        if (direction == Heading.NORTH_WEST) {
            Block newMove = new Block(location.getXCoor() - 1, location.getYCoor() - 1);
            path.add(location);
            location = newMove;
        }

        if (direction == Heading.NORTH_EAST) {
            Block newMove = new Block(location.getXCoor() + 1, location.getYCoor() - 1);
            path.add(location);
            location = newMove;
        }

        if (direction == Heading.SOUTH_WEST) {
            Block newMove = new Block(location.getXCoor() - 1, location.getYCoor() + 1);
            path.add(location);
            location = newMove;
        }

        if (direction == Heading.SOUTH_EAST) {
            Block newMove = new Block(location.getXCoor() + 1, location.getYCoor() + 1);
            path.add(location);
            location = newMove;
        }

        this.changed();
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
