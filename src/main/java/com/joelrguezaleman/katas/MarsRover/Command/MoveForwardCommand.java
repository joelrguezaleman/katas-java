package com.joelrguezaleman.katas.marsrover;

public class MoveForwardCommand implements Command
{
    public void run(Position position)
    {
        if (position.direction() == Directions.SOUTH) {
            position.decreaseY();
        } else if (position.direction() == Directions.WEST) {
            position.decreaseX();
        } else if (position.direction() == Directions.NORTH) {
            position.increaseY();
        } else {
            position.increaseX();
        }
    }
}
