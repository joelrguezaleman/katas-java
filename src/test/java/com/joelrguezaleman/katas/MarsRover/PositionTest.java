package com.joelrguezaleman.katas.marsrover;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PositionTest
{
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
            Arguments.of(-1, 0, RawDirections.EAST),
            Arguments.of(0, -1, RawDirections.EAST),
            Arguments.of(1, 1, '.')
        );
    }
}
