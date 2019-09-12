package com._8of;

// Write function that delete specific characters from mutable ASCII string
// Input two strings: delete characters that exist in second string from first string

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static String removeChars(String s, String remove) {
        Set<Character> removeChars = new HashSet<>();
        for (char c : remove.toCharArray()) {
            removeChars.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!removeChars.contains(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeChars("Battle of the Vowels", "aeiou")); // Bttl f th Vwls
    }
}
