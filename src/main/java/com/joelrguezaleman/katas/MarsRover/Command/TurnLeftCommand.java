package com.joelrguezaleman.katas.marsrover;

public class TurnLeftCommand implements Command
{
    public void run(Position position)
    {
        if (position.isSouth()) {
            position.setDirection(Directions.EAST);
        } else if (position.isWest()) {
            position.setDirection(Directions.SOUTH);
        } else if (position.isNorth()) {
            position.setDirection(Directions.WEST);
        } else {
            position.setDirection(Directions.NORTH);
        }
    }
}
