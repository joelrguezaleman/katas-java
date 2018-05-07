package com.joelrguezaleman.katas;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource("coordinatesProvider")
    public void itThrowsAnExceptionIfTheCoordinatesOrTheDirectionAreInvalid(Coordinates coordinates)
    {
        assertThrows(
            InvalidCoordinatesException.class,
            () -> {
                new MarsRover(coordinates, this.DIRECTION);
            }
        );
    }

    private static Stream<Arguments> coordinatesProvider()
    {
        return Stream.of(
            Arguments.of(new Coordinates(-1, 0)),
            Arguments.of(new Coordinates(0, -1))
        );
    }
}
