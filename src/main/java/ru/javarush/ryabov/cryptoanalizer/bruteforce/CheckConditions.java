package ru.javarush.ryabov.cryptoanalizer.bruteforce;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

public class CheckConditions {
    public static int checkConditions(String result) {
        if (otherConditions(result) == 1) {
            return 1;
        }
        for (int i = 0; i < result.length(); i++) {
            if (twoCharacters(result, i) == 1) {
                return 1;
                //3 согласных подряд
            }else if (Constants.RU_LOW_ALPHABET.contains(String.valueOf(result.charAt(i))) &&
                    Constants.RU_LOW_ALPHABET.contains(String.valueOf(result.charAt(i+1)))&&
                    Constants.RU_LOW_ALPHABET.contains(String.valueOf(result.charAt(i+2)))){
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
        /*
        Условия проверки двух символов
        */
        if (i < result.length() - 1) {
            //Условие на наличие двух одинаковых символов пунктуации подряд
            if (Constants.PUNCTUATION.contains(String.valueOf(result.charAt(i))) &&
                    Constants.PUNCTUATION.contains(String.valueOf(result.charAt(i + 1))) &&
                    result.charAt(i) == result.charAt(i + 1)) {
                return 1;
            }//Условие двух ёё йй ъъ ьь чч ыы цц гг шш щщ
            else if ("ёйъьчыцгшщЁЙЪЬЧЫЦГШЩ".contains(String.valueOf(result.charAt(i))) &
            result.charAt(i) == result.charAt(i+1)){
                return 1;
            }//Условие на ь или ъ или ы после гласной
            else if (Constants.VOWELS.contains(String.valueOf(result.charAt(i))) &
            "ьъыЬЪЫ".contains(String.valueOf(result.charAt(i+1)))){
                return 1;
            }//Заглавная после прописи
            else if (Constants.RU_LOW_ALPHABET.contains(String.valueOf(result.charAt(i))) &
            Constants.RU_LOW_ALPHABET.toUpperCase().contains(String.valueOf(result.charAt(i+1)))){
                return 1;
            }
        }
        return 0;
    }
}