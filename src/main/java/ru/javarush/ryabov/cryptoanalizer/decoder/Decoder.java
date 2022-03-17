package ru.javarush.ryabov.cryptoanalizer.decoder;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;
import ru.javarush.ryabov.cryptoanalizer.keyanalizer.KeyChecker;
import ru.javarush.ryabov.cryptoanalizer.tester.Tester;

import java.io.*;

public class Decoder {
    //Метод для консольного текста
    public static String textdecoder (String text){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (!Constants.RU_CONST.contains(character)){
                result.append(character);
                continue;
            }
            int oldIndex = Constants.RU_CONST.indexOf(character);
            int newIndex = (oldIndex - Tester.KEY)%Constants.RU_CONST.size();
            if (newIndex < 0){
                newIndex = Constants.RU_CONST.size()+newIndex;
            }
            result.append(Constants.RU_CONST.get(newIndex));
        }
        return result.toString();
    }
    //Метод для текстового файла
    public static void fileDecoder(String file, String exitFile) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(exitFile))){
            while (bufferedReader.ready()){
                int x = bufferedReader.read();
                char character = (char) x;
                if (!Constants.RU_CONST.contains(character)){
                    bufferedWriter.write(character);
                    continue;
                }
                int oldIndex = Constants.RU_CONST.indexOf(character);
                int newIndex = (oldIndex - Tester.KEY)%Constants.RU_CONST.size();
                if (newIndex < 0){
                    newIndex = Constants.RU_CONST.size()+newIndex;
                }
                bufferedWriter.write(Constants.RU_CONST.get(newIndex));
            }
        }
    }
}
