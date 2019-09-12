package com._8of;

// Print all permutations of the string
// Treat as character as distinct character
// So if string = "aaa", you need to print the same "aaa" six times

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static void printPermutations(String string) {
        for (String s : getPermutations(string.toCharArray())) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static String[] getPermutations(char[] chars) {
        List<String> list = new ArrayList<>();

        for (char c : chars) {
            if (list.isEmpty()) {
                list.add(new String(String.valueOf(c)));
                continue;
            }
            List<String> temp = new ArrayList<>();
            for (String s : list) {
                for (int i = s.length(); i >= 0; i--) {
                    boolean isFirstCharacterInsert = i == 0;
                    boolean isLastCharacterInsert = i == s.length();
                    String tempS = isFirstCharacterInsert
                            ? c + s // insert at 0 index
                            : (
                                    isLastCharacterInsert
                                            ? s + c // insert at the end
                                            : s.substring(0, i) + c + s.substring(i, s.length()) // common case
                            );
                    temp.add(tempS);
                }
            }
            list = temp;
        }

        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        printPermutations("ab"); // ab ba
        printPermutations("abc"); // abc acb cab bac bca cba
    }
}
