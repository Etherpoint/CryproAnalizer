package ru.javarush.ryabov.cryptoanalizer.bruteforce;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;

public class CheckWords {
    public static int checkWords (StringBuilder result){
        //Счетчик совпадений
        int coincidence = 0;
        for (String word : Constants.WORDS) {
            if (result.toString().toLowerCase().contains(word)){
                coincidence++;
            }
        }
        return coincidence;
    }
}