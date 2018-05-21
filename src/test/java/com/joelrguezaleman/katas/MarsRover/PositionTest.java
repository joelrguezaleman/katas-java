package com.joelrguezaleman.katas.marsrover;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PositionTest
{
    @ParameterizedTest
    @MethodSource("positionProvider")
    public void itCorrectlyTellsWhetherAPositionEqualsAnotherOneOrNot(
        Position position1,
        Position position2,
        boolean expectedResult
    ) {
        assertEquals(expectedResult, position1.equals(position2));
    }

    private static Stream<Arguments> positionProvider() throws InvalidPositionException
    {
        return Stream.of(
            Arguments.of(
                new Position(1, 1, Directions.EAST),
                new Position(1, 1, Directions.EAST),
                true
            ),
            Arguments.of(
                new Position(1, 1, Directions.EAST),
                new Position(2, 1, Directions.EAST),
                false
            ),
            Arguments.of(
                new Position(1, 1, Directions.EAST),
                new Position(1, 2, Directions.EAST),
                false
            ),
            Arguments.of(
                new Position(1, 1, Directions.EAST),
                new Position(1, 1, Directions.WEST),
                false
            )
        );
    }

    @ParameterizedTest
    @MethodSource("invalidPositionValuesProvider")
    public void itThrowsAnExceptionIfThePositionIsInvalid(int x, int y, char direction)
    {
        assertThrows(
            InvalidPositionException.class,
            () -> {
                new Position(x, y, direction);
            }
        );
    }

    private static Stream<Arguments> invalidPositionValuesProvider() throws InvalidPositionException
    {
        return Stream.of(
            Arguments.of(-1, 0, Directions.EAST),
            Arguments.of(0, -1, Directions.EAST),
            Arguments.of(1, 1, '.')
        );
    }
}
