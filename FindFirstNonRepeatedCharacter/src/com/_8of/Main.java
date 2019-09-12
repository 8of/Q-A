package com._8of;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find first NONrepeated character in a string

public class Main {

    private static Character firstNonRepeatedCharacter(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Map<Character, List<Integer>> chars = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (chars.containsKey(c)) {
                List<Integer> newIndexes = chars.get(c);
                newIndexes.add(i);
                chars.put(c, newIndexes);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                chars.put(c, newList);
            }
        }

        Character earliestChar = null;
        int earliestIndex = Integer.MAX_VALUE;

        for (char c : chars.keySet()) {
            List<Integer> indexes = chars.get(c);
            // Safe to check 0 index
            // We know the list is here and it's not empty
            boolean shouldUpdateMinChar = indexes.size() == 1 && indexes.get(0) < earliestIndex;
            if (shouldUpdateMinChar) {
                earliestChar = c;
                earliestIndex = indexes.get(0);
            }
        }

        return earliestChar;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatedCharacter("total")); // o
        System.out.println(firstNonRepeatedCharacter("teeter")); // r
        System.out.println(firstNonRepeatedCharacter("teetet")); // null
        System.out.println(firstNonRepeatedCharacter("")); // null
        System.out.println(firstNonRepeatedCharacter(null)); // null
    }
}
