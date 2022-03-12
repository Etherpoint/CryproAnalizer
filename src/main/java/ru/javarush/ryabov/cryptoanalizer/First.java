package ru.javarush.ryabov.cryptoanalizer;

public class First {
    public static final String RUSLOW = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static final String RUSHIGH = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    public static final String PUNCTUATION = "/?.,'\"}][{;:><_-+=|\\/)(*?&^%$№#@!~`";
    public static final String ENGLOW = "abcdefghijklmnopqrstuvwxyz";
    public static final String ENGHIGH = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";


    public static final String CONSTANTS = RUSLOW+RUSHIGH+PUNCTUATION+ ENGLOW + ENGHIGH + NUMBERS;

    public static void main(String[] args) {
        System.out.println(CONSTANTS);
    }
}
