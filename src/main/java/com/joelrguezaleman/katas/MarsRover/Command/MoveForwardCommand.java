package com.joelrguezaleman.katas.marsrover;

public class MoveForwardCommand implements Command
{
    public void run(Position position)
    {
        if (position.direction() == Directions.NORTH) {
            position.increaseY();
        } else {
            position.increaseX();
        }
    }
}
