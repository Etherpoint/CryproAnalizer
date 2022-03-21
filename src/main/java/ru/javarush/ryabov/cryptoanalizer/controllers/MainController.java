package ru.javarush.ryabov.cryptoanalizer.controllers;

import ru.javarush.ryabov.cryptoanalizer.commands.Action;
import ru.javarush.ryabov.cryptoanalizer.entity.Result;

public class MainController {
    public Result doAction(String actionName, String[] parameters) {
        Action action = Actions.find(actionName);
        Result result = action.execute(parameters);
        return result;
    }
}
