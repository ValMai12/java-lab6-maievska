package ua.edu.kpi.translator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Translator translator = new Translator();
        fillDictionary(translator);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                showMenu();
                System.out.print("Виберіть пункт: ");

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        addWord(scanner, translator);
                        break;
                    case "2":
                        translatePhrase(scanner, translator);
                        break;
                    case "0":
                        System.out.println("До побачення!");
                        return;
                    default:
                        System.out.println("Невірний пункт меню.");
                }
            }
        }
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

    private static void addWord(Scanner scanner, Translator translator) {
        System.out.print("Введіть англійське слово: ");
        String english = scanner.nextLine();

        System.out.print("Введіть український переклад: ");
        String ukrainian = scanner.nextLine();

        try {
            translator.addWord(english, ukrainian);
            System.out.println("Слово успішно додано до словника.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void translatePhrase(Scanner scanner, Translator translator) {
        System.out.print("Введіть фразу англійською мовою: ");
        String phrase = scanner.nextLine();

        if (phrase.isBlank()) {
            System.out.println("Фраза не може бути порожньою.");
            return;
        }

        System.out.println("Переклад: " + translator.translate(phrase));
    }
}
