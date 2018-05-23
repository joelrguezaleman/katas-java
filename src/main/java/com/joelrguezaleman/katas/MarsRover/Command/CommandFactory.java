package com.joelrguezaleman.katas.marsrover;

public class CommandFactory
{
    public Command create(char rawCommand)
    {
        if (rawCommand == MarsRoverCommands.BACKWARD) {
            return new MoveBackwardCommand();
        }

        return new MoveForwardCommand();
    }
}
