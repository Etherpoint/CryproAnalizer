package ru.javarush.ryabov.cryptoanalizer.console;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;
import ru.javarush.ryabov.cryptoanalizer.entity.Result;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Application application = new Application();
        args = getArgs(args);
        Result result = application.run(args);
        System.out.println(result);
    }

    //Переменная начальные функции
    public static final String SELECT_FUNCTION = """
            Введите цифру выбранной функции
            1. Encode
            2. Decode
            3. BruteForce
            """;

    //Переменная выводящая ошибку
    public static final String INCORRECT_SELECTION = "Incorrect selection";

    //Переменная с блоком вопросов
    private static final String[][][] QUESTIONS =new String[][][]{
            {
                    {"encode"},
                    {"Enter source (full path) OR Enter for text.txt", Constants.TXT_FOLDER + "text.txt"},
                    {"Enter destination (full path) OR Enter for encrypt.txt", Constants.TXT_FOLDER + "encrypt.txt"},
                    {"Enter key (int number OR Enter for key=1) :", "1"}
            },
            {
                    {"decode"},
                    {"Enter source (full path) OR Enter for encrypt.txt",  Constants.TXT_FOLDER + "encrypt.txt"},
                    {"Enter destination (full path) OR Enter for decrypt.txt", Constants.TXT_FOLDER + "decrypt.txt"},
                    {"Enter key (int number OR Enter for key=1) :", "1"}
            },
            {
                    {"bruteforce"},
                    {"Enter source (full path) OR Enter for encrypt.txt", Constants.TXT_FOLDER + "encrypt.txt"},
                    {"Enter destination (full path) OR Enter for bruteforce.txt", Constants.TXT_FOLDER + "bruteforce.txt"}
            }
    };

    //Метод получения аргументов с консоли
    private static String[] getArgs(String[] args) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            int mode = getMode(scanner);

            mode--;
            args = new String[QUESTIONS[mode].length];
            args[0] = QUESTIONS[mode][0][0];
            for (int i = 1; i < args.length; i++) {
                String quest = QUESTIONS[mode][i][0];
                System.out.println(quest);
                String answer = scanner.nextLine();
                args[i] = answer.isEmpty() ? QUESTIONS[mode][i][1] : answer;
            }
        }
        return args;
    }

    private static int getMode(Scanner scanner) {
        int mode;
        do {
            System.out.println(SELECT_FUNCTION);
            String input = scanner.nextLine();
            mode = switch (input){
                case "1" -> 1;
                case "2" -> 2;
                case "3" -> 3;
                default -> {
                    System.out.println(INCORRECT_SELECTION);
                    yield -1;
                }
            };
        }while (mode < 0);
        return mode;
    }
}