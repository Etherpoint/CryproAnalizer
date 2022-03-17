package ru.javarush.ryabov.cryptoanalizer.keyanalizer;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

public class KeyChecker {
    public static int keyChecker(String result) {
        //Условие наличия заглавных букв ЪЬЫ
        if (contains(result, "Ъ") || contains(result, "Ь") || contains(result, "Ы")){
            return 1;
        //Условие проверки первого символа
        }else if (contains("»,>;:)." + Constants.RU_LOW_ALPHABET, String.valueOf(result.charAt(0)))){
            return 1;
        }
        for (int i = 0; i < result.length(); i++) {
            /*
            Условия проверки двух символов
            */
            if (i < result.length() - 1) {

                //Условие на наличие двух символов пунктуации подряд
                if (contains(Constants.PUNCTUATION, String.valueOf(result.charAt(i))) &&
                        contains(Constants.PUNCTUATION, String.valueOf(result.charAt(i + 1)))){
                    return 1;

                //Условие на наличие двух заглавных подряд
                } else if (contains(Constants.RU_ALPHABET, String.valueOf(result.charAt(i))) &&
                        contains(Constants.RU_ALPHABET, String.valueOf(result.charAt(i + 1)))) {
                    return 1;

                //Условие на пробел после знака препинания
                } else if (contains(".,?!:;" , String.valueOf(result.charAt(i))) &&
                        result.charAt(i+1) != ' ') {
                    return 1;

                //Условие на Заглавную букву сразу после прописной
                }else if (contains(Constants.RU_LOW_ALPHABET, String.valueOf(result.charAt(i))) &&
                        contains(Constants.RU_ALPHABET, String.valueOf(result.charAt(i+1)))){
                    return 1;
                }
            }
            /*
            Условия проверки трех символов
            */
            if (i < result.length() - 2) {

                //условие 3 согласных подряд
                if (contains(Constants.CONSONANTS, String.valueOf(result.charAt(i)))) {
                    if (contains(Constants.CONSONANTS, String.valueOf(result.charAt(i + 1)))) {
                        if (contains(Constants.CONSONANTS, String.valueOf(result.charAt(i + 2)))) {
                            return 1;
                        }
                    }

                //Условие проверки трех одинаковых символов
                }else if (result.charAt(i) == result.charAt(i+1) &&
                        result.charAt(i)==result.charAt(i+2) &&
                        contains(Constants.RU_LOW_ALPHABET, String.valueOf(result.charAt(i)))){
                    return 1;
                }
            }
        }
        return 0;
    }

    public static boolean contains(String str, String substr) {
        return str.contains(substr);
    }
}
