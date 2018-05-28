package com.joelrguezaleman.katas.marsrover;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

        assertTrue(position.equals(expectedPosition));
    }

    private static Stream<Arguments> positionProvider() throws InvalidPositionException
    {
        return Stream.of(
            Arguments.of(
                new Position(0, 0, Directions.EAST),
                new Position(1, 0, Directions.EAST)
            ),
            Arguments.of(
                new Position(0, 0, Directions.NORTH),
                new Position(0, 1, Directions.NORTH)
            ),
            Arguments.of(
                new Position(1, 0, Directions.WEST),
                new Position(0, 0, Directions.WEST)
            ),
            Arguments.of(
                new Position(0, 1, Directions.SOUTH),
                new Position(0, 0, Directions.SOUTH)
            )
        );
    }
}
