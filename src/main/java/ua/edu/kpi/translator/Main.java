package ua.edu.kpi.translator;

public class Main {

    public static void main(String[] args) {
        Translator translator = new Translator();

        fillDictionary(translator);
        showMenu();
    }

    private static void fillDictionary(Translator translator) {
        translator.addWord("hello", "привіт");
        translator.addWord("world", "світ");
        translator.addWord("good", "добрий");
        translator.addWord("morning", "ранок");
        translator.addWord("beautiful", "красивий");
        translator.addWord("day", "день");
        translator.addWord("book", "книга");
        translator.addWord("friend", "друг");
        translator.addWord("I", "я");
        translator.addWord("love", "люблю");
        translator.addWord("Ukraine", "Україну");
        translator.addWord("coffee", "кава");
        translator.addWord("tea", "чай");
        translator.addWord("thank", "дякую");
        translator.addWord("you", "тобі");
    }

    private static void showMenu() {
        System.out.println("\nАнгло-український перекладач");
        System.out.println("1. Додати слово до словника");
        System.out.println("2. Перекласти фразу");
        System.out.println("0. Вийти");
    }
}
