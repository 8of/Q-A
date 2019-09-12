package com._8of;

import java.util.HashMap;
import java.util.Hashtable;

// Given a string, find the length of the longest substring without repeating characters.
class Solution {
    int lengthOfLongestSubstring(String s) {
        int maxLength = 1;
        int currentLength = 1;
        int currentSubstringStartIndex = 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> visited = new HashMap<>();
        for (Integer i = 0; i < chars.length; i++) {
            Character aChar = chars[i];
            if (visited.containsKey(aChar)) {
                Integer previousIndex = visited.get(aChar);
                if (previousIndex < currentSubstringStartIndex) {
                    currentLength++;
                } else {
                    currentSubstringStartIndex = previousIndex + 1;
                    maxLength = Math.max(maxLength, currentLength);
                    currentLength = i - previousIndex;
                }
            } else {
                currentLength++;
            }
            visited.put(aChar, i);
        }
        maxLength = Math.max(maxLength, currentLength);
        return maxLength;
    }
}
