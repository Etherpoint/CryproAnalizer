package ru.javarush.ryabov.cryptoanalizer.bruteforce;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

public class CheckConditions {
    public static int checkConditions(String result) {
        if (otherConditions(result) == 1) {
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

    public static int otherConditions(String result) {
        //Условие наличия заглавных букв ЪЬЫ
        if (result.contains("Ъ") || result.contains("Ь") || result.contains("Ы")) {
            return 1;
        }//Условие проверки первого символа
        else if (("»,>;:)." + Constants.RU_LOW_ALPHABET).contains(String.valueOf(result.charAt(0)))) {
            return 1;
        }
        return 0;
    }

    public static int twoCharacters(String result, int i) {
        //Условия проверки двух символов
        if (i < result.length() - 1) {
            //Условие двух ёё йй ъъ ьь чч ыы цц гг шш щщ
            if ("ёйъьчыцгшщЁЙЪЬЧЫЦГШЩ".contains(String.valueOf(result.charAt(i))) &
                    result.charAt(i) == result.charAt(i + 1)) {
                return 1;
            } else if (result.charAt(i) == '.' && Constants.PUNCTUATION.contains(String.valueOf(result.charAt(i + 1)))) {
                return 1;
            }
        }
        return 0;
    }
}