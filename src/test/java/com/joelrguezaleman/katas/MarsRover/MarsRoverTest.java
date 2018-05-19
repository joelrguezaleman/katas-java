package com.joelrguezaleman.katas;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MarsRoverTest
{
    @ParameterizedTest
    @MethodSource("coordinatesProvider")
    public void itThrowsAnExceptionIfTheCoordinatesOrTheDirectionAreInvalid(
        Coordinates coordinates
    ) {
        assertThrows(
            InvalidCoordinatesException.class,
            () -> {
                new MarsRover(coordinates, Directions.EAST);
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

    @ParameterizedTest
    @MethodSource("coordinatesAndCommandsProvider")
    public void itCorrectlyUpdatesThePositionOfTheMarsRover(
        Coordinates coordinates,
        char direction,
        char[] commands,
        int expectedXCoordinate,
        int expectedYCoordinate
    ) throws InvalidCoordinatesException {
        MarsRover marsRover = new MarsRover(coordinates, direction);

        marsRover.move(commands);

        Coordinates roverCoordinates = marsRover.coordinates();
        assertEquals(expectedXCoordinate, roverCoordinates.x);
        assertEquals(expectedYCoordinate, roverCoordinates.y);
    }

    private static Stream<Arguments> coordinatesAndCommandsProvider()
    {
        return Stream.of(
            // Send an empty array of commands, the MarsRover should not move
            Arguments.of(
                new Coordinates(0, 0),
                Directions.EAST,
                new char[0],
                0,
                0
            ),

            // Move the MarsRover forward
            Arguments.of(
                new Coordinates(0, 0),
                Directions.EAST,
                new char[]{MarsRoverCommands.FORWARD},
                1,
                0
            ),

            // Move the MarsRover backward
            Arguments.of(
                new Coordinates(1, 0),
                Directions.EAST,
                new char[]{MarsRoverCommands.BACKWARD},
                0,
                0
            )
        );
    }
}
