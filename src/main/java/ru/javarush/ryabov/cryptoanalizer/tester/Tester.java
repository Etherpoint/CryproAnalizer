package ru.javarush.ryabov.cryptoanalizer.tester;

import ru.javarush.ryabov.cryptoanalizer.decoder.Decoder;
import ru.javarush.ryabov.cryptoanalizer.encoder.Encoder;
import ru.javarush.ryabov.cryptoanalizer.keyanalizer.KeyAnalizer;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        System.out.println(Encoder.lineEncoder(message));
        System.out.println(Decoder.lineDecoder(Encoder.lineEncoder(message)));*/
        KeyAnalizer.keyAnalizer("Щътлоьfцтъ");
    }
}
