package com.joelrguezaleman.katas.marsrover;

public class TurnLeftCommand implements Command
{
    public void run(Position position)
    {
        if (position.isSouth()) {
            position.setDirection(RawDirections.EAST);
        } else if (position.isWest()) {
            position.setDirection(RawDirections.SOUTH);
        } else if (position.isNorth()) {
            position.setDirection(RawDirections.WEST);
        } else {
            position.setDirection(RawDirections.NORTH);
        }
    }
}
