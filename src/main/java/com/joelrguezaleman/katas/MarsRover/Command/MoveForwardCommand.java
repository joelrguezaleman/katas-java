package com.joelrguezaleman.katas.marsrover;

public class MoveForwardCommand implements Command
{
    public void run(Position position)
    {
        if (position.isSouth()) {
            position.decreaseY();
        } else if (position.isWest()) {
            position.decreaseX();
        } else if (position.isNorth()) {
            position.increaseY();
        } else {
            position.increaseX();
        }
    }
}
