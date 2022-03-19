package ru.javarush.ryabov.cryptoanalizer.commands;

import ru.javarush.ryabov.cryptoanalizer.bruteforce.CheckConditions;
import ru.javarush.ryabov.cryptoanalizer.bruteforce.CheckWords;
import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

import java.io.*;

public class BruteForce {
    public static void bruteForce(String text) {
        StringBuilder storage = new StringBuilder();
        int key = 0;
        for (int j = 0; j < Constants.RU_CONST.size(); j++) {
            int coincidence = 0;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                char character = text.charAt(i);
                if (!Constants.RU_CONST.contains(character)) {
                    result.append(character);
                    continue;
                }
                int oldCharIndex = Constants.RU_CONST.indexOf(character);
                int newCharIndex = (oldCharIndex - j) % Constants.RU_CONST.size();
                if (newCharIndex < 0) {
                    newCharIndex = Constants.RU_CONST.size() + newCharIndex;
                }
                result.append(Constants.RU_CONST.get(newCharIndex));
            }
            if (CheckConditions.checkConditions(result.toString()) == 0) {
                if (CheckWords.checkWords(result) > coincidence){
                    storage = result;
                    key = j;
                }
                //System.out.println("Возможная расшифровка: " + result + " , ключ шифрования: " + key);
            }else{
                result.delete(0, result.length());
            }
        }
        System.out.println("Возможная расшифровка: " + storage + ", ключ шифрования: " + key);
    }

    public static void fileBruteForce(String input, String output) throws IOException {
        StringBuilder storage = new StringBuilder();
        int key = 0;
        for (int j = 0; j < Constants.RU_CONST.size(); j++) {
            int coincidence = 0;
            StringBuilder result = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
                while (bufferedReader.ready()) {
                    int x = bufferedReader.read();
                    char character = (char) x;
                    if (!Constants.RU_CONST.contains(character)) {
                        result.append(character);
                        continue;
                    }
                    int oldIndex = Constants.RU_CONST.indexOf(character);
                    int newIndex = (oldIndex - j) % Constants.RU_CONST.size();
                    if (newIndex < 0) {
                        newIndex = Constants.RU_CONST.size() + newIndex;
                    }
                    result.append(Constants.RU_CONST.get(newIndex));
                }
                if (CheckConditions.checkConditions(result.toString()) == 0) {
                    if (CheckWords.checkWords(result) > coincidence) {
                        storage = result;
                        key = j;
                        storage.append("\n Ключ от шифра: ").append(key);
                    }
                }else{
                    result.delete(0, result.length());
                }
            }try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))){
                for (int i = 0; i < storage.length(); i++) {
                    char character = storage.charAt(i);
                    if (!Constants.RU_CONST.contains(character)) {
                        bufferedWriter.write(character);
                        continue;
                    }
                    bufferedWriter.write(character);
                }
            }
        }

    }
}