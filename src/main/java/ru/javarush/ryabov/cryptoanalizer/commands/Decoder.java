package ru.javarush.ryabov.cryptoanalizer.commands;

import ru.javarush.ryabov.cryptoanalizer.entity.Result;
import ru.javarush.ryabov.cryptoanalizer.constants.Constants;
import ru.javarush.ryabov.cryptoanalizer.entity.ResultCode;
import ru.javarush.ryabov.cryptoanalizer.exceptions.AppException;

import java.io.*;

public class Decoder implements Action {
    /*//Метод для консольного текста
    public static String textDecoder (String text){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (!Constants.RU_CONST.contains(character)){
                result.append(character);
                continue;
            }
            int oldIndex = Constants.RU_CONST.indexOf(character);
            int newIndex = (oldIndex - ConsoleRunner.KEY)%Constants.RU_CONST.size();
            if (newIndex < 0){
                newIndex = Constants.RU_CONST.size()+newIndex;
            }
            result.append(Constants.RU_CONST.get(newIndex));
        }
        return result.toString();
    }*/
    //Метод для текстового файла
    public static void fileDecoder(String file, String exitFile, int key) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(exitFile))) {
            while (bufferedReader.ready()) {
                int x = bufferedReader.read();
                char character = (char) x;
                if (!Constants.RU_CONST.contains(character)) {
                    bufferedWriter.write(character);
                    continue;
                }
                int oldIndex = Constants.RU_CONST.indexOf(character);
                int newIndex = (oldIndex - key) % Constants.RU_CONST.size();
                if (newIndex < 0) {
                    newIndex = Constants.RU_CONST.size() + newIndex;
                }
                bufferedWriter.write(Constants.RU_CONST.get(newIndex));
            }
        }
    }

    @Override
    public Result execute(String[] parameters) {
        try {
            String input = parameters[0];
            String output = parameters[1];
            int key = Integer.parseInt(parameters[2]);
            fileDecoder(input, output, key);
            return new Result("Decode complete", ResultCode.OK);
        } catch (IOException e) {
            throw new AppException("invalid parameters");
        }
    }
}
