package com.joelrguezaleman.katas.marsrover;

public class CommandFactory
{
    public Command create(char rawCommand)
    {
        switch (rawCommand) {
            case MarsRoverCommands.RIGHT:
                return new TurnRightCommand();
            case MarsRoverCommands.LEFT:
                return new TurnLeftCommand();
            case MarsRoverCommands.BACKWARD:
                return new MoveBackwardCommand();
            default:
                return new MoveForwardCommand();
        }
    }
}
