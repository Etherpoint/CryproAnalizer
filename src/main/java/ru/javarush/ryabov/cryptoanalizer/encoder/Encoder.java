package ru.javarush.ryabov.cryptoanalizer.encoder;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

public class Encoder {
    public static String lineEncoder(String text) {
        StringBuilder result = new StringBuilder();
        //String text = "Привет мир!";
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            for (int j = 0; j < Constants.CONSTANTS.length; j++) {
                if (Constants.CONSTANTS[j] == character) {
                    if ((j + Constants.KEY) > Constants.CONSTANTS.length - 1) {
                        int index = j + Constants.KEY;
                        while ((index > (Constants.CONSTANTS.length - 1))) {
                            index -= Constants.CONSTANTS.length;
                        }
                        result.append(Constants.CONSTANTS[index]);
                    } else {
                        result.append(Constants.CONSTANTS[j + Constants.KEY]);
                    }
                    break;
                }
            }
        }
        return result.toString();
    }
}
