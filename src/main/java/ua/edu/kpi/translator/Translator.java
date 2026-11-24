package ua.edu.kpi.translator;

import java.util.HashMap;
import java.util.Locale;

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
}
