package com.joelrguezaleman.katas;

public class Position
{
    private char direction;
    private int x;
    private int y;

    public Position(int x, int y, char direction)
    {
        this.direction = direction;
        this.x         = x;
        this.y         = y;
    }

    public char direction()
    {
        return this.direction;
    }

    public int x()
    {
        return this.x;
    }

    public int y()
    {
        return this.y;
    }

    public void increaseX()
    {
        this.x++;
    }

    public void decreaseX()
    {
        this.x--;
    }
}
