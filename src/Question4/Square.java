package Question4;

/**
 *
 * @author Warrick Wills - 13831575
 */
public class Square {
    private boolean isWall;
    private int x, y;
    private boolean isVisited;
    
    public Square(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.isWall = true;
        this.isVisited = false;
    }
    
    public String getStringRepresentation() 
    {
        if(!isWall)
        {
            return " ";
        }
        return "#";
    }

    public boolean isIsWall() {
        return isWall;
    }

    public void setIsWall(boolean isWall) {
        this.isWall = isWall;
    }
    
    public boolean isVisited()
    {
        return isVisited;
    }
    public void setVisited() {
        isVisited = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
