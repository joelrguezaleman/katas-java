package com.joelrguezaleman.katas.marsrover;

public class CommandFactory
{
    public Command create(char rawCommand) throws InvalidCommandException
    {
        switch (rawCommand) {
            case RawCommands.BACKWARD:
                return new MoveBackwardCommand();
            case RawCommands.FORWARD:
                return new MoveForwardCommand();
            case RawCommands.LEFT:
                return new TurnLeftCommand();
            case RawCommands.RIGHT:
                return new TurnRightCommand();
            default:
                throw new InvalidCommandException();
        }
    }
}
