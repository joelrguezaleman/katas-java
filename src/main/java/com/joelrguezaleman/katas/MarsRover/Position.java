package com.joelrguezaleman.katas.marsrover;

public class Position
{
    private int x;
    private int y;
    private Direction direction;

    public Position(int x, int y, char rawDirection) throws InvalidPositionException
    {
        if (this.invalidCoordinates(x, y)) {
            throw new InvalidPositionException();
        }

        this.x         = x;
        this.y         = y;
        this.direction = new Direction(rawDirection);
    }

    private boolean invalidCoordinates(int x, int y)
    {
        return x < 0 || y < 0;
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
        return this.direction.isNorth();
    }

    public boolean isEast()
    {
        return this.direction.isEast();
    }

    public boolean isSouth()
    {
        return this.direction.isSouth();
    }

    public boolean isWest()
    {
        return this.direction.isWest();
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

    public void turnLeft()
    {
        this.direction.turnLeft();
    }

    public void turnRight()
    {
        this.direction.turnRight();
    }
}
