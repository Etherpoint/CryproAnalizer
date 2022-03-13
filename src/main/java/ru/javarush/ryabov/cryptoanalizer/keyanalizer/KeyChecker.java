package ru.javarush.ryabov.cryptoanalizer.keyanalizer;

import ru.javarush.ryabov.cryptoanalizer.constants.AnalizerConstants;

public class KeyChecker {
    public static void keyChecker (String result, int key){
        int error = 2;
        for (int i = 0; i < result.length(); i++) {
            char character = result.charAt(i);
            if (i == 0 && (character == 'ъ' || character == 'Ъ' || character == 'ь' || character == 'Ь')) {
                error = 1;
                break;
            } else if ((AnalizerConstants.RUSCONSONANTS.toCharArray().equals(character)) &&
                    (AnalizerConstants.RUSCONSONANTS.toCharArray().equals(result.charAt(i + 1))) &&
                    (AnalizerConstants.RUSCONSONANTS.toCharArray().equals(result.charAt(i + 2)))) {
                error = 1;
                break;
            }
        }
        if (error == 0){
            System.out.println("Возможный ключ: " + key + " , результат: " + result);
        }else if (error == 1){
            System.out.println("Ключ " + key + " не подходит, результат: " + result);
        }
    }
}
