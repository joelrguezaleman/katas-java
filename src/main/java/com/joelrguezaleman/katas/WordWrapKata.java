package com.joelrguezaleman.katas;

import java.lang.StringBuilder;

public class WordWrapKata
{
    public static String wrap(String text, int columnNumber) throws Exception
    {
        if (columnNumber < 1) {
            throw new Exception();
        }

        return wrapText(text, columnNumber);
    }

    private static String wrapText(String text, int columnNumber)
    {
        StringBuilder wrappableText = new StringBuilder(text);

        int lastSpaceIndex = -1;
        int textLength = text.length();
        int usedCharacters = 0;
        for (int i=0; i<textLength; i++) {
            if (text.charAt(i) == ' ') {
                lastSpaceIndex = i;
            }
            if (usedCharacters != columnNumber) {
                usedCharacters++;
            } else {
                usedCharacters = i - lastSpaceIndex;
                if (lastSpaceIndex == -1) {
                    wrappableText.insert(i, '\n');
                } else {
                    wrappableText.setCharAt(lastSpaceIndex, '\n');
                    lastSpaceIndex = -1;
                }
            }
        }

        return wrappableText.toString();
    }
}
