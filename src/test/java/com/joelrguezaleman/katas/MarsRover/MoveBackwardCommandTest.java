package com.joelrguezaleman.katas.marsrover;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MoveBackwardCommandTest
{
    @ParameterizedTest
    @MethodSource("positionProvider")
    public void itUpdatesThePositionInABackwardDirection(
        Position position,
        Position expectedPosition
    ) {
        MoveBackwardCommand command = new MoveBackwardCommand();

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
                new Position(1, 0, Directions.EAST),
                new Position(0, 0, Directions.EAST)
            ),
            Arguments.of(
                new Position(0, 1, Directions.NORTH),
                new Position(0, 0, Directions.NORTH)
            ),
            Arguments.of(
                new Position(0, 0, Directions.WEST),
                new Position(1, 0, Directions.WEST)
            ),
            Arguments.of(
                new Position(0, 0, Directions.SOUTH),
                new Position(0, 1, Directions.SOUTH)
            )
        );
    }
}
