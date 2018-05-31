package com.joelrguezaleman.katas.marsrover;

public class TurnRightCommand implements Command
{
    public void run(Position position)
    {
        position.turnRight();
    }
}
