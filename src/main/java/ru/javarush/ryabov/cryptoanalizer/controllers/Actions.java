package ru.javarush.ryabov.cryptoanalizer.controllers;

import ru.javarush.ryabov.cryptoanalizer.commands.Action;
import ru.javarush.ryabov.cryptoanalizer.commands.BruteForce;
import ru.javarush.ryabov.cryptoanalizer.commands.Decoder;
import ru.javarush.ryabov.cryptoanalizer.commands.Encoder;
import ru.javarush.ryabov.cryptoanalizer.exceptions.AppException;

import java.util.Locale;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCE(new BruteForce());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }
    public static Action find(String actionName){
        try{
            Actions value = Actions.valueOf(actionName.toUpperCase());
            return value.action;
        }catch (IllegalArgumentException e){
            throw new AppException();
        }
    }
}
