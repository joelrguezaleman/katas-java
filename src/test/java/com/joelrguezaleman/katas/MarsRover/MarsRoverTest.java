package com.joelrguezaleman.katas;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MarsRoverTest
{
    @ParameterizedTest
    @MethodSource("positionProvider")
    public void itThrowsAnExceptionIfThePositionIsInvalid(
        Position position
    ) {
        assertThrows(
            InvalidPositionException.class,
            () -> {
                new MarsRover(position);
            }
        );
    }

    private static Stream<Arguments> positionProvider()
    {
        return Stream.of(
            Arguments.of(new Position(-1, 0, Directions.EAST)),
            Arguments.of(new Position(0, -1, Directions.EAST))
        );
    }

    @ParameterizedTest
    @MethodSource("positionAndCommandsProvider")
    public void itCorrectlyUpdatesThePositionOfTheMarsRover(
        Position position,
        char[] commands,
        Position expectedPosition
    ) throws InvalidPositionException {
        MarsRover marsRover = new MarsRover(position);

        marsRover.move(commands);

        assertTrue(expectedPosition.equals(marsRover.position()));
    }

    private static Stream<Arguments> positionAndCommandsProvider()
    {
        return Stream.of(
            // Send an empty array of commands, the MarsRover should not move
            Arguments.of(
                new Position(0, 0, Directions.EAST),
                new char[0],
                new Position(0, 0, Directions.EAST)
            ),

            // Move the MarsRover forward
            Arguments.of(
                new Position(0, 0, Directions.EAST),
                new char[]{MarsRoverCommands.FORWARD},
                new Position(1, 0, Directions.EAST)
            ),

            // Move the MarsRover backward
            Arguments.of(
                new Position(1, 0, Directions.EAST),
                new char[]{MarsRoverCommands.BACKWARD},
                new Position(0, 0, Directions.EAST)
            )
        );
    }
}
