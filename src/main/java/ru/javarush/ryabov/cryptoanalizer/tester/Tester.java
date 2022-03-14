package ru.javarush.ryabov.cryptoanalizer.tester;

import ru.javarush.ryabov.cryptoanalizer.decoder.Decoder;
import ru.javarush.ryabov.cryptoanalizer.encoder.Encoder;
import ru.javarush.ryabov.cryptoanalizer.keyanalizer.KeyAnalizer;

import java.io.IOException;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(Encoder.lineEncoder(input));
        System.out.println(Decoder.lineDecoder(Encoder.lineEncoder(input)));
        //String output = scanner.nextLine();
        //Encoder.fileEncoder(input, output);
        //Decoder.fileDecoder(input, output);
        //KeyAnalizer.keyAnalizer("ьпыалыаоллдапы");
    }
}
