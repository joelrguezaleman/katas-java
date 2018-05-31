package com.joelrguezaleman.katas.marsrover;

public class TurnRightCommand implements Command
{
    public void run(Position position)
    {
        if (position.isSouth()) {
            position.setDirection(RawDirections.WEST);
        } else if (position.isWest()) {
            position.setDirection(RawDirections.NORTH);
        } else if (position.isNorth()) {
            position.setDirection(RawDirections.EAST);
        } else {
            position.setDirection(RawDirections.SOUTH);
        }
    }
}
