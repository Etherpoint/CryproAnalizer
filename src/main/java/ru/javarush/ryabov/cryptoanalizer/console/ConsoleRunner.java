package ru.javarush.ryabov.cryptoanalizer.console;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;
import ru.javarush.ryabov.cryptoanalizer.entity.Result;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ConsoleRunner {

    public static void main(String[] args) throws IOException {
        Application application = new Application();
        Result result = application.run(args);
    }
}