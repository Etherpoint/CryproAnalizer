package ru.javarush.ryabov.cryptoanalizer.commands;

import ru.javarush.ryabov.cryptoanalizer.bruteforce.CheckConditions;
import ru.javarush.ryabov.cryptoanalizer.constants.Constants;
import ru.javarush.ryabov.cryptoanalizer.tester.Tester;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class BruteForce {
    public static void bruteForce(String text) {
        for (int key = 0; key < Constants.RU_CONST.size(); key++) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                char character = text.charAt(i);
                if (!Constants.RU_CONST.contains(character)) {
                    result.append(character);
                    continue;
                }
                int oldCharIndex = Constants.RU_CONST.indexOf(character);
                int newCharIndex = (oldCharIndex - key) % Constants.RU_CONST.size();
                if (newCharIndex < 0) {
                    newCharIndex = Constants.RU_CONST.size() + newCharIndex;
                }
                result.append(Constants.RU_CONST.get(newCharIndex));
            }
            if (CheckConditions.checkConditions(result.toString()) == 0) {
                System.out.println("Возможная расшифровка: " + result + " , ключ шифрования: " + key);
            }else{
                result.delete(0, result.length());
            }
        }
    }

    public static void fileBruteForce(String input) throws IOException {
        for (int key = 0; key < Constants.RU_CONST.size(); key++) {
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
                while (bufferedReader.ready()) {
                    int x = bufferedReader.read();
                    char character = (char) x;
                    if (!Constants.RU_CONST.contains(character)) {
                        stringBuilder.append(character);
                        continue;
                    }
                    int oldIndex = Constants.RU_CONST.indexOf(character);
                    int newIndex = (oldIndex - key) % Constants.RU_CONST.size();
                    if (newIndex < 0) {
                        newIndex = Constants.RU_CONST.size() + newIndex;
                    }
                    stringBuilder.append(Constants.RU_CONST.get(newIndex));
                }
                if (CheckConditions.checkConditions(stringBuilder.toString()) == 0) {
                    System.out.println("Возможная расшифровка: " + stringBuilder + " , ключ: " + key);
                }
            }
        }
    }
}