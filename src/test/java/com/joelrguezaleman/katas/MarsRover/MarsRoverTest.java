package com.joelrguezaleman.katas.marsrover;

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
    @MethodSource("positionAndCommandsProvider")
    public void itCorrectlyUpdatesThePositionOfTheMarsRover(
        Position position,
        char[] commands,
        Position expectedPosition
    ) throws InvalidCommandException {
        CommandFactory commandFactory = new CommandFactory();
        MarsRover marsRover           = new MarsRover(commandFactory, position);

        marsRover.move(commands);

        assertEquals(expectedPosition.x(), marsRover.position().x());
        assertEquals(expectedPosition.y(), marsRover.position().y());
        assertEquals(expectedPosition.isNorth(), marsRover.position().isNorth());
        assertEquals(expectedPosition.isEast(), marsRover.position().isEast());
        assertEquals(expectedPosition.isSouth(), marsRover.position().isSouth());
        assertEquals(expectedPosition.isWest(), marsRover.position().isWest());
    }

    private static Stream<Arguments> positionAndCommandsProvider() throws InvalidPositionException
    {
        return Stream.of(
            // Send an empty array of commands, the MarsRover should not move
            Arguments.of(
                new Position(0, 0, RawDirections.EAST),
                new char[0],
                new Position(0, 0, RawDirections.EAST)
            ),

            // Move the MarsRover forward
            Arguments.of(
                new Position(0, 0, RawDirections.EAST),
                new char[]{RawCommands.FORWARD},
                new Position(1, 0, RawDirections.EAST)
            ),

            // Move the MarsRover backward
            Arguments.of(
                new Position(1, 0, RawDirections.EAST),
                new char[]{RawCommands.BACKWARD},
                new Position(0, 0, RawDirections.EAST)
            ),

            // Move the MarsRover left
            Arguments.of(
                new Position(0, 0, RawDirections.EAST),
                new char[]{RawCommands.LEFT},
                new Position(0, 0, RawDirections.NORTH)
            )
        );
    }
}
