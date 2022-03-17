package ru.javarush.ryabov.cryptoanalizer.tester;

import ru.javarush.ryabov.cryptoanalizer.decoder.Decoder;
import ru.javarush.ryabov.cryptoanalizer.encoder.Encoder;
import ru.javarush.ryabov.cryptoanalizer.keyanalizer.BruteForce;

import java.io.IOException;
import java.util.Scanner;

public class Tester {
    public static int KEY;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = scanner.nextLine();
        String output2 = scanner.nextLine();

        KEY = scanner.nextInt();
        Encoder.fileEncoder(input, output);
        Decoder.fileDecoder(output, output2);
        /*System.out.println(Encoder.textencoder("Привет"));
        BruteForce.bruteForce(Encoder.textencoder("Привет"));*/
    }
}
