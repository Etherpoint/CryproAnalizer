package ru.javarush.ryabov.cryptoanalizer.bruteforce;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

public class CheckConditions {
    public static int checkConditions(String result) {
        //Проверяем циклом все символы на правила русского языка
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == 'Ь' | result.charAt(i) == 'Ъ'){
                return 1;
            } else if (twoCharacters(result, i) == 1 |
                    threeCharacters(result, i) == 1 |
                    fourCharacters(result, i) == 1) {
                return 1;
            }
        }
        return 0;
    }

    public static int twoCharacters(String result, int i) {
        //Условия проверки двух символов
        if (i < result.length() - 1) {
            //Два символа ъ ь й ё ц ш щ ф ч ы х д к г з
            if ("ъьйёчЪЬЙЁЧ".contains(String.valueOf(result.charAt(i))) &&
                    String.valueOf(result.charAt(i)).equalsIgnoreCase(String.valueOf(result.charAt(i + 1)))) {
                return 1;
            }
        }
        return 0;
    }

    public static int threeCharacters(String result, int i) {
        //Условия проверки трех символов
        if (i < result.length() - 2) {

        }
        return 0;
    }

    public static int fourCharacters(String result, int i) {
        //Условия проверки четырех символов
        if (i < result.length() - 3) {
            if (Constants.RU_LOW_ALPHABET.toUpperCase().contains(String.valueOf(result.charAt(i))) &
                    Constants.RU_LOW_ALPHABET.toUpperCase().contains(String.valueOf(result.charAt(i + 1))) &
                    Constants.RU_LOW_ALPHABET.toUpperCase().contains(String.valueOf(result.charAt(i + 2))) &
                    Constants.RU_LOW_ALPHABET.toUpperCase().contains(String.valueOf(result.charAt(i + 3)))) {
                return 1;
            }
        }
        return 0;
    }
}