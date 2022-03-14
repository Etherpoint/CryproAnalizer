package ru.javarush.ryabov.cryptoanalizer.constants;

public class Constants {
    private static final String RUS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String PUNCTUATION = "/?.,'}][{;:><_-+=|)(*&^%$№#@!~` «»—…";
    private static final String RUPUNCTUATION = "?.,;:><_-+=()*^%#@№!«»—…";
    private static final String ENG = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SHIELDING = "\t\n\"\\\b\r\f";
    public static final String STRINGCONSTANTS = RUS + RUS.toUpperCase() + PUNCTUATION + ENG + ENG.toUpperCase()+ SHIELDING + NUMBERS;

    public static final String RUSCONST = RUS + RUS.toUpperCase() + RUPUNCTUATION;

    public static final int KEY = 10;
}
