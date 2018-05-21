package com.joelrguezaleman.katas.marsrover;

public class MarsRover
{
    private Position position;

    public MarsRover(Position position)
    {
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
