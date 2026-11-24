package ua.edu.kpi.translator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TranslatorTest {

    private Translator translator;

    @BeforeEach
    void setUp() {
        translator = new Translator();
        translator.addWord("hello", "привіт");
        translator.addWord("world", "світ");
        translator.addWord("beautiful", "красивий");
    }

    @Test
    void testTranslateWord() {
        assertEquals("привіт", translator.translate("hello"));
    }

    @Test
    void testTranslatePhrase() {
        assertEquals("привіт світ", translator.translate("hello world"));
    }

    @Test
    void testAddWord() {
        translator.addWord("cat", "кіт");
        assertEquals("красивий кіт", translator.translate("beautiful cat"));
    }

    @Test
    void testUpperCase() {
        assertEquals("привіт світ", translator.translate("HELLO World"));
    }

    @Test
    void testPunctuation() {
        assertEquals("привіт, світ!", translator.translate("Hello, world!"));
    }

    @Test
    void testUnknownWord() {
        assertEquals("привіт student", translator.translate("hello student"));
    }

    @Test
    void testEmptyPhrase() {
        assertEquals("", translator.translate(""));
    }

    @Test
    void testExtraSpaces() {
        assertEquals("привіт світ", translator.translate("  hello   world  "));
    }

    @Test
    void testUpdateWord() {
        translator.addWord("hello", "вітаю");
        assertEquals("вітаю", translator.translate("hello"));
    }

    @Test
    void testInvalidWord() {
        assertThrows(IllegalArgumentException.class,
                () -> translator.addWord("", "слово"));

        assertThrows(IllegalArgumentException.class,
                () -> translator.addWord("word", ""));
    }
}
