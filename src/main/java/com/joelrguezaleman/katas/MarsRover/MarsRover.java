package com.joelrguezaleman.katas.marsrover;

public class MarsRover
{
    private CommandFactory commandFactory;
    private Position position;

    public MarsRover(
        CommandFactory commandFactory,
        Position position
    ) {
        this.commandFactory = commandFactory;
        this.position       = position;
    }

    public void move(char[] commands)
    {
        for (char command : commands) {
            if (command == RawCommands.FORWARD) {
                this.position.increaseX();
            } else if (command == RawCommands.LEFT) {
                this.position.turnLeft();
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
