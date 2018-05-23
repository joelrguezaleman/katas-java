package com.joelrguezaleman.katas.marsrover;

public class CommandFactory
{
    public Command create(char rawCommand) throws InvalidCommandException
    {
        switch (rawCommand) {
            case MarsRoverCommands.BACKWARD:
                return new MoveBackwardCommand();
            case MarsRoverCommands.FORWARD:
                return new MoveForwardCommand();
            case MarsRoverCommands.LEFT:
                return new TurnLeftCommand();
            case MarsRoverCommands.RIGHT:
                return new TurnRightCommand();
            default:
                throw new InvalidCommandException();
        }
    }
}
