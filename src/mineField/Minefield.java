package mineField;

import java.awt.Color;
import java.lang.invoke.WrongMethodTypeException;
import java.util.*;
import java.util.List;
import tools.*;
import mvc.*;

public class Minefield extends Model {
    public static Integer WORLD_SIZE = 20;
    int x, y;
    List<Block> path;
    boolean takenFlag;
    boolean checkMineFlag;
    private Heading direction;
    Block[][] boardArray = new Block[WORLD_SIZE][WORLD_SIZE];

    public Minefield() {
        x = y = 0;
        for (int i = 0; i < WORLD_SIZE; i++) {
            for (int j = 0; j < WORLD_SIZE; j++) {
                boardArray[i][j] = new Block(i, j);
            }
        }
        boardArray[WORLD_SIZE-1][WORLD_SIZE-1].setEndPoint(true);
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

    public int getYpos() {
        return y;
    }

    public int getXpos() {
        return x;
    }

    public int getSurroundingMines() {
        int count = 0;
        List<Block> tempList = new LinkedList<Block>();
        if (x != 0) {
            tempList.add(boardArray[x - 1][y]);
        }
        if (y != 0) {
            tempList.add(boardArray[x][y - 1]);
        }
        if (x != WORLD_SIZE - 1) {
            tempList.add(boardArray[x + 1][y]);
        }
        if (y != WORLD_SIZE - 1) {
            tempList.add(boardArray[x][y + 1]);
        }
        if (x != 0 && y != 0) {
            tempList.add(boardArray[x - 1][y - 1]);
        }
        if (x != 0 && y != WORLD_SIZE - 1) {
            tempList.add(boardArray[x - 1][y + 1]);
        }
        if (x != WORLD_SIZE - 1 && y != 0) {
            tempList.add(boardArray[x + 1][y - 1]);
        }
        if (x != WORLD_SIZE - 1 && y != WORLD_SIZE - 1) {
            tempList.add(boardArray[x + 1][y + 1]);
        }

        for (Block x : tempList) {
            if (x.blockHasMine() == true) count++;
        }
        return count;
    }


    public boolean checkGetMined() {
        if (path.get(path.size() - 1).blockHasMine() == true) {
            return true;
            //System.out.println("Game Over!!!");
        } else return false;

    }

    public boolean checkGetHome() {
        if ((x == WORLD_SIZE - 1) &&
                (y == WORLD_SIZE - 1)) {
            return true;
            //win game!!!!
        } else return false;

    }

    /* move method moves the player in the direction of the heading
    throws exceptions if the player steps on a mine or wins
     */
    public void move() throws Exception {
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
        if (x >= WORLD_SIZE) {
            x--;
        } else if (x < 0) {
            x++;
        }
        if (y >= WORLD_SIZE) {
            y--;
        } else if (y < 0) {
            y++;
        }
        changed();
        if(boardArray[x][y].getEndPoint()){
            throw new Exception("win");
        }
        if(boardArray[x][y].blockHasMine()){
            throw new Exception("lose");
        }
    }

    public void turn(Heading direction) {
        this.direction = direction;
    }
}