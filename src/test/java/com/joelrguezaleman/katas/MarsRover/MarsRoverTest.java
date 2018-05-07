package com.joelrguezaleman.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MarsRoverTest
{
    final private char DIRECTION = 'N';

    @Test
    public void itDoesNotMoveTheMarsRoverIfGivenAnEmptyArrayOfCommands() throws InvalidCoordinatesException
    {
        Coordinates coordinates = new Coordinates(0, 0);
        MarsRover marsRover     = new MarsRover(coordinates, this.DIRECTION);
        char[] commands         = new char[0];

        marsRover.move(commands);

        Coordinates roverCoordinates = marsRover.coordinates();
        assertEquals(0, roverCoordinates.x);
        assertEquals(0, roverCoordinates.y);
    }

    @Test
    public void itThrowsAnExceptionIfTheCoordinatesOrTheDirectionAreInvalid()
    {
        Coordinates coordinates = new Coordinates(-1, 0);

        assertThrows(
            InvalidCoordinatesException.class,
            () -> {
                new MarsRover(coordinates, this.DIRECTION);
            }
        );
    }
}
