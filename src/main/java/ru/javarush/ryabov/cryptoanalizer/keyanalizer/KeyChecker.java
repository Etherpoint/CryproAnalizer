package ru.javarush.ryabov.cryptoanalizer.keyanalizer;

import ru.javarush.ryabov.cryptoanalizer.constants.AnalizerConstants;
import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

public class KeyChecker {
    public static void keyChecker(String result) {
        for (int i = 0; i < result.length(); i++) {
            char character = result.charAt(i);

            //условие 3 согласных подряд
            if (contains(Constants.CONSONANTS, String.valueOf(character))){
                if (contains(Constants.CONSONANTS, String.valueOf(result.charAt(i+1)))){
                    if (contains(Constants.CONSONANTS, String.valueOf(result.charAt(i+2)))){
                        System.out.println("Невалидный ключ");
                        break;
                    }
                }
            }
        }
    }

    public static boolean contains(String str, String substr) {
        return str.contains(substr);
    }
}
