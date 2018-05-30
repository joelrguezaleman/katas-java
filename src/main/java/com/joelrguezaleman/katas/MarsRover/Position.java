package com.joelrguezaleman.katas.marsrover;

public class Position
{
    private int x;
    private int y;
    private char direction;

    public Position(int x, int y, char direction) throws InvalidPositionException
    {
        if (this.invalidCoordinates(x, y) || this.invalidDirection(direction)) {
            throw new InvalidPositionException();
        }

        this.x         = x;
        this.y         = y;
        this.direction = direction;
    }

    private boolean invalidCoordinates(int x, int y)
    {
        return x < 0 || y < 0;
    }

    private boolean invalidDirection(char direction)
    {
        return
            direction != Directions.NORTH
            && direction != Directions.EAST
            && direction != Directions.SOUTH
            && direction != Directions.WEST;
    }

    public int x()
    {
        return this.x;
    }

    public int y()
    {
        return this.y;
    }

    public boolean isNorth()
    {
        return direction == Directions.NORTH;
    }

    public boolean isEast()
    {
        return direction == Directions.EAST;
    }

    public boolean isSouth()
    {
        return direction == Directions.SOUTH;
    }

    public boolean isWest()
    {
        return direction == Directions.WEST;
    }

    public void increaseX()
    {
        this.x++;
    }

    public void decreaseX()
    {
        this.x--;
    }

    public void increaseY()
    {
        this.y++;
    }

    public void decreaseY()
    {
        this.y--;
    }

    public void setDirection(char direction)
    {
        this.direction = direction;
    }
}
