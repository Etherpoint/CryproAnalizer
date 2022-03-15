package ru.javarush.ryabov.cryptoanalizer.keyanalizer;

import ru.javarush.ryabov.cryptoanalizer.constants.AnalizerConstants;
import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

public class KeyAnalizer {
    /*public static void keyAnalizer(String text) {
        int key = 1;
        for (key = 1; key < 20; key++) {
            StringBuilder result = new StringBuilder();

            //Создаем цикл для посимвольной проверки текста

            for (int i = 0; i < text.length(); i++) {
                char character = text.charAt(i);

                //Создаем внутренний цикл для сравнения с константой

                for (int j = 0; j < Constants.CONSTANTS.length; j++) {
                    if (Constants.CONSTANTS[j] == character) {
                        if ((j - key) < 0) {
                            int index = j - key;
                            while (index < 0) {
                                index += Constants.CONSTANTS.length;
                            }
                            result.append(Constants.CONSTANTS[index]);
                        } else {
                            result.append(Constants.CONSTANTS[j - key]);
                        }
                        break;
                    }
                }
            }
            //Проверяем ключ на адекватный результат
            KeyChecker.keyChecker(result.toString());
        }
    }*/

    //МЕТОД НА ДОРАБОТКЕ
    /*public static void keyAnalizer (String text){
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            String word = String.valueOf(character);

            //Условие содержания знаков
            boolean condition = KeyChecker.contains(word, Constants.RUSCONST);
            if (!condition) {
                while (!condition) {
                    String newText = text.replace(character, Constants.CHAR_RUCONST[i]);
                    keyAnalizer(newText);
                }
            }
            KeyChecker.keyChecker(text);
        }
    }*/
}
