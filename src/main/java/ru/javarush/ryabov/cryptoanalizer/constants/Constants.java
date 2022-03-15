package ru.javarush.ryabov.cryptoanalizer.constants;

public class Constants {
    private static final String RUS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String RUPUNCTUATION = "?.,;:><_-+=()*^%#@№!«»—…";
    private static final String NUMBERS = "0123456789";

    public static final String CONSONANTS = "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФЧЦЧШЩ";
    public static final String RUSCONST = RUS + RUS.toUpperCase() + RUPUNCTUATION + NUMBERS;
    public static final char[] CHAR_RUCONST = RUSCONST.toCharArray();

    public static final int KEY = 10;
}
