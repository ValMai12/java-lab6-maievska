package ua.edu.kpi.translator;

import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {

    private final HashMap<String, String> dictionary = new HashMap<>();

    public void addWord(String english, String ukrainian) {
        if (english == null || ukrainian == null
                || english.isBlank() || ukrainian.isBlank()) {
            throw new IllegalArgumentException("Слова не можуть бути порожніми.");
        }

        dictionary.put(
                english.trim().toLowerCase(Locale.ROOT),
                ukrainian.trim()
        );
    }

    public String translate(String phrase) {
        if (phrase == null || phrase.isBlank()) {
            return "";
        }

        String text = phrase.trim().replaceAll("\\s+", " ");
        Pattern pattern = Pattern.compile("[a-zA-Z]+(?:'[a-zA-Z]+)*");
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            String word = matcher.group();
            String translation = dictionary.getOrDefault(
                    word.toLowerCase(Locale.ROOT), word
            );

            matcher.appendReplacement(
                    result, Matcher.quoteReplacement(translation)
            );
        }

        matcher.appendTail(result);

        return result.toString();
    }
}
