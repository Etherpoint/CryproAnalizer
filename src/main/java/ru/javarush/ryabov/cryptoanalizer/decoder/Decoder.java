package ru.javarush.ryabov.cryptoanalizer.decoder;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

import java.io.*;

public class Decoder {
    public static String lineDecoder(String line) {
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
        return result.toString();
    }
    public static void fileDecoder(String file, String exitFile) throws IOException {
        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(exitFile))){
            while (bufferedReader.ready()){
                int x = bufferedReader.read();
                bufferedWriter.write(x-Constants.KEY);
            }
        }
    }
}
