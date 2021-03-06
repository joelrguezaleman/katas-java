package com.joelrguezaleman.katas.wordwrap;

import java.lang.StringBuilder;

public class WordWrap
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
        int usedCharacters = 0;

        for (int i=0; i<wrappableText.length(); i++) {
            if (wrappableText.charAt(i) == ' ') {
                lastSpaceIndex = i;
            }
            if (usedCharacters != columnNumber) {
                usedCharacters++;
            } else {
                if (lastSpaceIndex == -1) {
                    wrappableText.insert(i, '\n');
                    usedCharacters = 0;
                } else {
                    wrappableText.setCharAt(lastSpaceIndex, '\n');
                    usedCharacters = i - lastSpaceIndex;
                    lastSpaceIndex = -1;
                }
            }
        }

        return wrappableText.toString();
    }
}
