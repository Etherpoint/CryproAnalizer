package ru.javarush.ryabov.cryptoanalizer.constants;

import java.util.*;

public class Constants {
    private static final String RUS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    //private static final String RUPUNCTUATION = "?.,;:><_-+=()*^%#@№!«»—…";
    private static final String NUMBERS = "0123456789";

    public static final String CONSONANTS = "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФЧЦЧШЩ";
    //public static final String RUSCONST = RUS + RUS.toUpperCase() + RUPUNCTUATION + NUMBERS;
    public static final List<Character> RUCONST = new ArrayList<>(Arrays.asList('a', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н',
            'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж',
            'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', '0',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '?', '.', ',', ';', ':', '>', '<', '_', '-', '+', '=', '(', ')', '*', '^', '%', '#',
            '@', '№', '!', '«', '»', '—', '…', ' '));
}
