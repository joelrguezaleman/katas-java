package com.joelrguezaleman.katas.marsrover;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CommandFactoryTest
{
    @ParameterizedTest
    @MethodSource("positionProvider")
    public void itBuildsAnInstanceOfTheCorrectClassGivenARawCommand(
        char rawCommand,
        String expectedCommandClass
    ) throws InvalidCommandException {
        CommandFactory factory = new CommandFactory();

        Command command = factory.create(rawCommand);

        assertEquals(expectedCommandClass, command.getClass().getSimpleName());
    }

    private static Stream<Arguments> positionProvider()
    {
        return Stream.of(
            Arguments.of(
                MarsRoverCommands.FORWARD,
                MoveForwardCommand.class.getSimpleName()
            ),
            Arguments.of(
                MarsRoverCommands.BACKWARD,
                MoveBackwardCommand.class.getSimpleName()
            ),
            Arguments.of(
                MarsRoverCommands.LEFT,
                TurnLeftCommand.class.getSimpleName()
            ),
            Arguments.of(
                MarsRoverCommands.RIGHT,
                TurnRightCommand.class.getSimpleName()
            )
        );
    }

    @Test
    public void itThrowsAnExceptionIfTheCommandIsInvalid()
    {
        CommandFactory factory = new CommandFactory();

        assertThrows(
            InvalidCommandException.class,
            () -> {
                factory.create('.');
            }
        );
    }
}
