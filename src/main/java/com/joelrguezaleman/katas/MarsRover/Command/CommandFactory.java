package com.joelrguezaleman.katas.marsrover;

public class CommandFactory
{
    public MoveForwardCommand create(char rawCommand)
    {
        return new MoveForwardCommand();
    }
}
