package com.joelrguezaleman.katas.marsrover;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MoveForwardCommandTest
{
    @ParameterizedTest
    @MethodSource("positionProvider")
    public void itUpdatesThePositionInAForwardDirection(
        Position position,
        Position expectedPosition
    ) {
        MoveForwardCommand command = new MoveForwardCommand();

        command.run(position);

        assertEquals(expectedPosition.x(), position.x());
        assertEquals(expectedPosition.y(), position.y());
        assertEquals(expectedPosition.isNorth(), position.isNorth());
        assertEquals(expectedPosition.isEast(), position.isEast());
        assertEquals(expectedPosition.isSouth(), position.isSouth());
        assertEquals(expectedPosition.isWest(), position.isWest());
    }

    private static Stream<Arguments> positionProvider() throws InvalidPositionException
    {
        return Stream.of(
            Arguments.of(
                new Position(0, 0, RawDirections.EAST),
                new Position(1, 0, RawDirections.EAST)
            ),
            Arguments.of(
                new Position(0, 0, RawDirections.NORTH),
                new Position(0, 1, RawDirections.NORTH)
            ),
            Arguments.of(
                new Position(1, 0, RawDirections.WEST),
                new Position(0, 0, RawDirections.WEST)
            ),
            Arguments.of(
                new Position(0, 1, RawDirections.SOUTH),
                new Position(0, 0, RawDirections.SOUTH)
            )
        );
    }
}
