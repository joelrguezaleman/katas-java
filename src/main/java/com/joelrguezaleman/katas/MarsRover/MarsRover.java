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
            if (command == RawCommands.FORWARD) {
                this.position.increaseX();
            } else if (command == RawCommands.LEFT) {
                this.position.setDirection(Directions.NORTH);
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
