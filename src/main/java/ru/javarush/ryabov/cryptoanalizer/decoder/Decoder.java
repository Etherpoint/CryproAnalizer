package ru.javarush.ryabov.cryptoanalizer.decoder;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

public class Decoder {
    public static void main(String[] args) {
        String line = "Щътлоьjцтъg";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char character = line.charAt(i);
            for (int j = 0; j < Constants.CONSTANTS.length; j++) {
                if (Constants.CONSTANTS[j] == character) {
                    if ((j - Constants.KEY) < 0) {
                        int index = j - Constants.KEY;
                        while (index < 0) {
                            index += Constants.CONSTANTS.length;
                        }
                        result.append(Constants.CONSTANTS[index]);
                    } else {
                        result.append(Constants.CONSTANTS[j - Constants.KEY]);
                    }
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
