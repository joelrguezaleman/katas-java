package com.joelrguezaleman.katas.marsrover;

public class MoveForwardCommand implements Command
{
    public void run(Position position)
    {
        position.increaseX();
    }
}
