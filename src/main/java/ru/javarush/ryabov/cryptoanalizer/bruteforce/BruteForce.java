package ru.javarush.ryabov.cryptoanalizer.bruteforce;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

public class BruteForce {
    public static void bruteForce(String text) {
        for (int key = -Constants.RU_CONST.size(); key < Constants.RU_CONST.size(); key++) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                char character = text.charAt(i);
                if (!Constants.RU_CONST.contains(character)){
                    result.append(character);
                    continue;
                }
                int oldIndex = Constants.RU_CONST.indexOf(character);
                int newIndex = (oldIndex - key) % Constants.RU_CONST.size();
                if (newIndex < 0){
                    newIndex = Constants.RU_CONST.size()+newIndex;
                }
                result.append(Constants.RU_CONST.get(newIndex));
            }
            if (CheckConditions.checkConditions(result.toString()) == 0){
                System.out.println("Возможная расшифровка: " + result + " , ключ шифрования: " + key);
            }
        }
    }
}