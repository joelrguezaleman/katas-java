package com.joelrguezaleman.katas;

public class Position
{
    private int x;
    private int y;
    private char direction;

    public Position(int x, int y, char direction)
    {
        this.x         = x;
        this.y         = y;
        this.direction = direction;
    }

    public int x()
    {
        return this.x;
    }

    public int y()
    {
        return this.y;
    }

    public char direction()
    {
        return this.direction;
    }

    public void increaseX()
    {
        this.x++;
    }

    public void decreaseX()
    {
        this.x--;
    }

    public boolean equals(Position position)
    {
        return this.x == position.x()
            && this.y == position.y()
            && this.direction == position.direction();
    }
}
