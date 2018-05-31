package com.joelrguezaleman.katas.marsrover;

public class Direction
{
    private char rawDirection;

    public Direction(char rawDirection) throws InvalidPositionException
    {
        if (this.invalidDirection(rawDirection)) {
            throw new InvalidPositionException();
        }

        this.rawDirection = rawDirection;
    }

    private boolean invalidDirection(char direction)
    {
        return
            direction != RawDirections.NORTH
            && direction != RawDirections.EAST
            && direction != RawDirections.SOUTH
            && direction != RawDirections.WEST;
    }

    public boolean isNorth()
    {
        return this.rawDirection == RawDirections.NORTH;
    }

    public boolean isEast()
    {
        return this.rawDirection == RawDirections.EAST;
    }

    public boolean isSouth()
    {
        return this.rawDirection == RawDirections.SOUTH;
    }

    public boolean isWest()
    {
        return this.rawDirection == RawDirections.WEST;
    }

    public void turnLeft()
    {
        if (this.isSouth()) {
            this.rawDirection = RawDirections.EAST;
        } else if (this.isWest()) {
            this.rawDirection = RawDirections.SOUTH;
        } else if (this.isNorth()) {
            this.rawDirection = RawDirections.WEST;
        } else {
            this.rawDirection = RawDirections.NORTH;
        }
    }

    public void turnRight()
    {
        if (this.isSouth()) {
            this.rawDirection = RawDirections.WEST;
        } else if (this.isWest()) {
            this.rawDirection = RawDirections.NORTH;
        } else if (this.isNorth()) {
            this.rawDirection = RawDirections.EAST;
        } else {
            this.rawDirection = RawDirections.SOUTH;
        }
    }
}
