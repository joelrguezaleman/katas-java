package com.joelrguezaleman.katas;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
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

    @ParameterizedTest
    @MethodSource("textsProvider")
    public void itReturnsATextCorrectlyWrapped(
        String text,
        int columnNumber,
        String expectedResult
    ) throws Exception {
        String result = WordWrapKata.wrap(text, columnNumber);

        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> textsProvider()
    {
        return Stream.of(
            Arguments.of("", 1, ""),
            Arguments.of("text", 2, "te\nxt"),
            Arguments.of("text", 5, "text"),
            Arguments.of("this text", 6, "this\ntext"),
            Arguments.of("this text", 4, "this\ntext"),
            Arguments.of("this example", 4, "this\nexam\nple"),
            Arguments.of("this longer text", 10, "this\nlonger\ntext"),
            Arguments.of(
                "a long time ago in a galaxy far far away",
                10,
                "a long\ntime ago\nin a\ngalaxy far\nfar away"
            ),
            Arguments.of(
                "superlongword but then shorter ones",
                10,
                "superlongw\nord but\nthen\nshorter\nones"
            ),
            Arguments.of(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas vitae lacinia leo. Praesent sit amet nisi a libero posuere volutpat elementum quis enim. Integer efficitur, purus sed ultricies varius, orci massa malesuada mi, quis ultricies urna dolor sed lorem. Pellentesque ut turpis eleifend, consequat ex nec, egestas felis.",
                30,
                "Lorem ipsum dolor sit amet,\nconsectetur adipiscing elit.\nMaecenas vitae lacinia leo.\nPraesent sit amet nisi a\nlibero posuere volutpat\nelementum quis enim. Integer\nefficitur, purus sed ultricies\nvarius, orci massa malesuada\nmi, quis ultricies urna dolor\nsed lorem. Pellentesque ut\nturpis eleifend, consequat ex\nnec, egestas felis."
            )
        );
    }
}
