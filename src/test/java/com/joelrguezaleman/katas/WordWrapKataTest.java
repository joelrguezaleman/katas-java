package com.joelrguezaleman.katas;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WordWrapKataTest
{
    @ParameterizedTest
    @MethodSource("invalidColumnNumbersProvider")
    public void itThrowsAnExceptionWhenTheColumnNumberIs0OrLower(int columnNumber)
    {
        assertThrows(
            Exception.class,
            () -> {
                WordWrapKata.wrap("", columnNumber);
            }
        );
    }

    private static Stream<Arguments> invalidColumnNumbersProvider()
    {
        return Stream.of(
            Arguments.of(0),
            Arguments.of(-1)
        );
    }
}
