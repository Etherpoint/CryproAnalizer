package ru.javarush.ryabov.cryptoanalizer.constants;

public class Constants {
    private static final String RUSLOW = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String RUSHIGH = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String PUNCTUATION = "/?.,'\"}][{;:><_-+=|\\/)(*?&^%$№#@!~`";
    private static final String ENGLOW = "abcdefghijklmnopqrstuvwxyz";
    private static final String ENGHIGH = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    public static final String CONSTANTS = RUSLOW+RUSHIGH+PUNCTUATION+ ENGLOW + ENGHIGH + NUMBERS;
}
