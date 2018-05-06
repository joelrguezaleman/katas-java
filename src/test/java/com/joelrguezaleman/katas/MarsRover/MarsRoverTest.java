package com.joelrguezaleman.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MarsRoverTest
{
    @Test
    public void itDoesNotMoveTheMarsRoverIfGivenAnEmptyArrayOfCommands()
    {
        Coordinates coordinates = new Coordinates(0, 0);
        char direction          = 'N';
        MarsRover marsRover     = new MarsRover(coordinates, direction);
        char[] commands         = new char[0];

        marsRover.move(commands);

        Coordinates roverCoordinates = marsRover.coordinates();
        assertEquals(0, roverCoordinates.x);
        assertEquals(0, roverCoordinates.y);
    }
}
