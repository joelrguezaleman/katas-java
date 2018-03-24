package com.joelrguezaleman.katas;

public class WordWrapKata
{
    public static String wrap(String text, int columnNumber) throws Exception
    {
        if (columnNumber < 1) {
            throw new Exception();
        }

        return addNewlineCharactersToText(text, columnNumber);
    }

    private static String addNewlineCharactersToText(String text, int columnNumber)
    {
        String wrappedText = "";

        int textLength = text.length();
        for (int i=0; i<textLength; i++) {
            if (i == columnNumber) {
                wrappedText += '\n';
            }
            wrappedText += text.charAt(i);
        }

        return wrappedText;
    }
}
