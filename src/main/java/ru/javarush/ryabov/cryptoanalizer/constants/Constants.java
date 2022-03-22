package ru.javarush.ryabov.cryptoanalizer.constants;

import java.io.File;
import java.util.*;

public class Constants {
    public static final List<Character> RU_CONST = new ArrayList<>(Arrays.asList('а','б', 'в', 'г', 'д', 'е', 'ё', 'ж',
            'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы',
            'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П',
            'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', '?', '.', ',','!', '"',
            '\'', '^'));

    public static final String[] WORDS = new String[] {"год", "человек", "время", "дело", "жизнь", "рука", "день",
            "раз", "работа", "слово", "место", "лицо", "друг", "глаз", "вопрос", "дом", "сторона", "страна", "мир", "случай"};

    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "texts" + File.separator;
}