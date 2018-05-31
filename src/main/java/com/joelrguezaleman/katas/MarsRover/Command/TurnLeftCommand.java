package com.joelrguezaleman.katas.marsrover;

public class TurnLeftCommand implements Command
{
    public void run(Position position)
    {
        position.turnLeft();
    }
}
