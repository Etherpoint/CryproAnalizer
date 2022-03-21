package ru.javarush.ryabov.cryptoanalizer.commands;

import ru.javarush.ryabov.cryptoanalizer.entity.Result;

public interface Action {
    public Result execute(String[] parameters);
}
