package com.joelrguezaleman.katas;

public class MarsRover
{
    private Position position;

    public MarsRover(Position position) throws InvalidPositionException
    {
        if (position.x() < 0 || position.y() < 0) {
            throw new InvalidPositionException();
        }

        this.position = position;
    }

    public void move(char[] commands)
    {
        for (char command : commands) {
            if (command == MarsRoverCommands.FORWARD) {
                this.position.increaseX();
            } else {
                this.position.decreaseX();
            }
        }
    }

    public Position position()
    {
        return this.position;
    }
}
