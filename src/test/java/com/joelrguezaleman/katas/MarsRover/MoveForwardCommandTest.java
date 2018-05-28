package com.joelrguezaleman.katas.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MoveForwardCommandTest
{
    @Test
    public void itUpdatesThePositionInAForwardDirection() throws InvalidPositionException
    {
        int xCoordinate = 0;
        int yCoordinate = 0;
        Position position = new Position(xCoordinate, yCoordinate, Directions.EAST);
        MoveForwardCommand command = new MoveForwardCommand();

        command.run(position);

        assertEquals(1, position.x());
    }
}
