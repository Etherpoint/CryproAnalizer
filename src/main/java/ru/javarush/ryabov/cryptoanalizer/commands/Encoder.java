package ru.javarush.ryabov.cryptoanalizer.commands;

import ru.javarush.ryabov.cryptoanalizer.entity.Result;
import ru.javarush.ryabov.cryptoanalizer.constants.Constants;
import ru.javarush.ryabov.cryptoanalizer.entity.ResultCode;
import ru.javarush.ryabov.cryptoanalizer.exceptions.AppException;

import java.io.*;
import java.nio.file.Path;

public class Encoder implements Action {
    /*//Метод для консольного текста
    public static String textEncoder (String text){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (!Constants.RU_CONST.contains(character)){
                result.append(character);
                continue;
            }
            int oldIndex = Constants.RU_CONST.indexOf(character);
            int newIndex = (oldIndex + ConsoleRunner.KEY)%Constants.RU_CONST.size();
            result.append(Constants.RU_CONST.get(newIndex));
        }
        return result.toString();
    }*/
    //Метод для текстового файла
    public static Result fileEncoder(String input, String output, int key) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))) {
            while (bufferedReader.ready()) {
                int x = bufferedReader.read();
                char character = (char) x;
                if (!Constants.RU_CONST.contains(character)) {
                    bufferedWriter.write(character);
                    continue;
                }
                int oldIndex = Constants.RU_CONST.indexOf(character);
                int newIndex = (oldIndex + key) % Constants.RU_CONST.size();
                bufferedWriter.write(Constants.RU_CONST.get(newIndex));
            }
        }
        return new Result ("Метод успешнно завершен", ResultCode.OK);
    }

    @Override
    public Result execute(String[] parameters) {
        try {
            String input = Constants.TXT_FOLDER + parameters[0];
            String output = Constants.TXT_FOLDER + parameters[1];
            int key = Integer.parseInt(parameters[2]);
            return fileEncoder(input, output, key);
        }catch (IOException e){
            throw new AppException("Невалидные данные");
        }
    }
}
