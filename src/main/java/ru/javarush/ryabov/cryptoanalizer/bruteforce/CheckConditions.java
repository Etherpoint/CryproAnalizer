package ru.javarush.ryabov.cryptoanalizer.bruteforce;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

public class CheckConditions {
    public static int checkConditions(String result) {
        if (result.contains("Ь") | result.contains("Ъ")) {
            return 1;
        }
        //Проверяем циклом все символы на правила русского языка
        for (int i = 0; i < result.length(); i++) {
            if (twoCharacters(result, i) == 1) {
                return 1;
            }
        }
        return 0;
    }

    public static int twoCharacters(String result, int i) {
        //Условия проверки двух символов
        if (i < result.length() - 1) {
            //Два символа ъ ь й ё ч ы
            if ("ъьйёчыЪЬЙЁЧЫ".contains(String.valueOf(result.charAt(i))) &&
                    String.valueOf(result.charAt(i)).equalsIgnoreCase(String.valueOf(result.charAt(i + 1)))) {
                return 1;
            }
        }
        return 0;
    }
}