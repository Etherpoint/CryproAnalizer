package ru.javarush.ryabov.cryptoanalizer.decoder;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;
import ru.javarush.ryabov.cryptoanalizer.tester.Tester;

import java.io.*;

public class Decoder {
    //Метод для консольного текста
    public static String textdecoder (String text){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (!Constants.RUCONST.contains(character)){
                result.append(character);
                continue;
            }
            int oldIndex = Constants.RUCONST.indexOf(character);
            int newIndex = (oldIndex - Tester.KEY)%Constants.RUCONST.size();
            if (newIndex < 0){
                newIndex = Constants.RUCONST.size()+newIndex;
            }
            result.append(Constants.RUCONST.get(newIndex));
        }
        return result.toString();
    }
    //Метод для текстового файла
    public static void fileDecoder(String file, String exitFile) throws IOException {
        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(exitFile))){
            while (bufferedReader.ready()){
                int x = bufferedReader.read();
                bufferedWriter.write(x-Tester.KEY);
            }
        }
    }
}
