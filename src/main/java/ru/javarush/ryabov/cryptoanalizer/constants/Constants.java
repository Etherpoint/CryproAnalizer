package ru.javarush.ryabov.cryptoanalizer.constants;

public class Constants {
    private static final String RUS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String PUNCTUATION = "/?.,'\"}][{;:><_-+=|\\/)(*?&^%$№#@!~` ";
    private static final String ENG = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String STRINGCONSTANTS = RUS + RUS.toUpperCase() + PUNCTUATION + ENG + ENG.toUpperCase() + NUMBERS;

    public static final int KEY = 1523678268;

    public static final char[] CONSTANTS = STRINGCONSTANTS.toCharArray();
}
