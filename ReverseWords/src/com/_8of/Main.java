package com._8of;

// Reverse words in a sentence
// Words should be in reverse order
// But letters in words should be in the same order
// Count punctuation as a part of the word

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        String[] words = s.split(" ");
        List<String> list = Arrays.asList(words);
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Do or do not, there is no try.")); // try. no is there not, do or Do
    }
}
