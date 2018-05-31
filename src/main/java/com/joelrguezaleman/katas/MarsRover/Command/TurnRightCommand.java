package com.joelrguezaleman.katas.marsrover;

public class TurnRightCommand implements Command
{
    public void run(Position position)
    {
        if (position.isSouth()) {
            position.setDirection(Directions.WEST);
        } else if (position.isWest()) {
            position.setDirection(Directions.NORTH);
        } else if (position.isNorth()) {
            position.setDirection(Directions.EAST);
        } else {
            position.setDirection(Directions.SOUTH);
        }
    }
}
