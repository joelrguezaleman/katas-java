package com.joelrguezaleman.katas.marsrover;

public class MoveBackwardCommand implements Command
{
    public void run(Position position)
    {
        if (position.isSouth()) {
            position.increaseY();
        } else if (position.isWest()) {
            position.increaseX();
        } else if (position.isNorth()) {
            position.decreaseY();
        } else {
            position.decreaseX();
        }
    }
}
