package ru.javarush.ryabov.cryptoanalizer.keyanalizer;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BruteForce {
    public static void bruteForce(String text) {
        //Собираем уникальные символы в сет
        String copyText = new String (text);
        HashSet<Character> unique = new HashSet<>();
        for (char character : text.toCharArray()) {
            unique.add(character);
        }
        //Проходимся по сету и меняем символы в тексте
        do {
            for (char character : unique) {
                ArrayList<Character> copy = new ArrayList<>((Constants.RUCONST));
                int index = (int) (Math.random() * copy.size());
                char randomizer = copy.get(index);
                copyText.replace(character, randomizer);
                copy.remove((Object) randomizer);
            }
        }while (!(KeyChecker.keyChecker(copyText)));{
            copyText = null;
        }
    }

}