package com.joelrguezaleman.katas;

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
        String wrappedText = "";

        int usedCharacters = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            word = wrapWord(word, columnNumber);
            String wordSeparator = getWordSeparator(word, usedCharacters, columnNumber);
            word = usedCharacters == 0 ? word : wordSeparator + word;
            wrappedText += word;
            usedCharacters = calculateUsedCharacters(wrappedText);
        }

        return wrappedText;
    }

    private static String wrapWord(String word, int columnNumber)
    {
        if (word.length() <= columnNumber) {
            return word;
        }

        String wrappedWord = "";

        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            if (i > 0 && i % columnNumber == 0) {
                wrappedWord += '\n';
            }
            wrappedWord += word.charAt(i);
        }

        return wrappedWord;
    }

    private static String getWordSeparator(String word, int usedCharacters, int columnNumber)
    {
        return usedCharacters + word.length() + 1 <= columnNumber ? " " : "\n";
    }

    private static int calculateUsedCharacters(String wrappedText)
    {
        return wrappedText.lastIndexOf('\n') == -1
            ? wrappedText.length()
            : wrappedText.substring(wrappedText.lastIndexOf('\n')).length();
    }
}
