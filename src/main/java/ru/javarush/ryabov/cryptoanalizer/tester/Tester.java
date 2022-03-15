package ru.javarush.ryabov.cryptoanalizer.tester;

import ru.javarush.ryabov.cryptoanalizer.constants.Constants;
import ru.javarush.ryabov.cryptoanalizer.decoder.Decoder;
import ru.javarush.ryabov.cryptoanalizer.encoder.Encoder;
import ru.javarush.ryabov.cryptoanalizer.keyanalizer.KeyAnalizer;
import ru.javarush.ryabov.cryptoanalizer.keyanalizer.KeyChecker;

import java.io.IOException;
import java.util.Scanner;

public class Tester {
    public static int KEY;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //String input = scanner.nextLine();
        //String output = scanner.nextLine();
        KEY = scanner.nextInt();
        System.out.println(Encoder.textencoder("Привет мир!"));
        System.out.println(Decoder.textdecoder(Encoder.textencoder("Привет мир!")));
    }
}
