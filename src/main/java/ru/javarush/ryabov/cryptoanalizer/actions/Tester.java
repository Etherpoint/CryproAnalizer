package ru.javarush.ryabov.cryptoanalizer.actions;

import ru.javarush.ryabov.cryptoanalizer.exceptions.AppExceptions;
import ru.javarush.ryabov.cryptoanalizer.commands.BruteForce;
import ru.javarush.ryabov.cryptoanalizer.commands.Decoder;
import ru.javarush.ryabov.cryptoanalizer.commands.Encoder;

import java.io.IOException;
import java.util.Scanner;

public class Tester {
    public static int KEY;

    public static void main(String[] args) throws IOException, AppExceptions {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Введите номер операции:
                1. ШИФРОВАТЬ ТЕКСТ
                2. ШИФРОВАТЬ ФАЙЛ
                3. РАСШИФРОВАТЬ ТЕКСТ (С КЛЮЧОМ)
                4. РАСШИФРОВАТЬ ФАЙЛ (С КЛЮЧОМ)
                5. РАСШИФРОВАТЬ ТЕСТ (БЕЗ КЛЮЧА)
                6. РАСШИФРОВАТЬ ФАЙЛ (БЕЗ КЛЮЧА)
                """);
        //KEY = scanner.nextInt();
    }
}