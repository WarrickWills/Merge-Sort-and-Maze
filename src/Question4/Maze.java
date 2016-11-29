package Question4;

import java.util.Random;
import java.util.Stack;

/**
 *
 * @author Warrick Wills - 13831575
 */
public class Maze {

    private int row;
    private int column;
    private Square[][] maze;
    private boolean[][] visited;

    public Maze(int row, int column) {
        this.row = row;
        this.column = column;
        maze = new Square[this.row][this.column];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = new Square(j, i);
            }
        }
    }

    public void display() {
        for (int i = 0; i < column; i++) {
            // draw the north edge
            for (int j = 0; j < row; j++) {
                System.out.print((maze[j][i].getStringRepresentation()));
            }
            System.out.println("");
        }
    }

    public boolean isPathPossible(int x, int y) {
        if (x < 1 || y < 1 || x > maze[y].length - 2 || y > maze.length - 2) {
            return false;
        } 
        return true;
    }

    
    public Direction randDirection() {
        Direction[] x = Direction.values();
        Random r = new Random();
        int a = r.nextInt(4);
        return x[a];
    }
    
    public void explore(Square v) {
        //Random r = new Random();
        v.setIsWall(false);
        int x = v.getX();
        int y= v.getY();
        
        Position nextDestination = calcPosition(x, y,randDirection());
        //while the all direction of v is not visited
            //if(nextDestination is not Visited)
                //nextdetinations next position is set visited;
                //explore(getSqare(nextDestination); 
             //else
                //return;
            
    }

    public Position calcPosition(int x, int y, Direction d) {
        int retX = x;
        int retY = y;
        switch (d) {
            case EAST:
                retX += 2;
                break;
            case NORTH:
                retY -= 2;
                break;
            case SOUTH:
                retY += 2;
                break;
            case WEST:
                retX -= 2;
                break;
        }
        return new Position(retX, retY);
    }

    public static void main(String[] args) {
        Maze m = new Maze(9, 9);
        m.display();
    }
}
