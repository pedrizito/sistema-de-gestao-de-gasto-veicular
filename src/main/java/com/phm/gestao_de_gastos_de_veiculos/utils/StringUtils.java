package com.phm.gestao_de_gastos_de_veiculos.utils;

public class StringUtils {

    public static String capitalizeWords(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.split(" ");
        StringBuilder capitalizedWords = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                capitalizedWords.append(word.substring(0, 1).toUpperCase())
                                 .append(word.substring(1).toLowerCase())
                                 .append(" ");
            }
        }

        return capitalizedWords.toString().trim();
    }
}