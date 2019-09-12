package com._8of;

class Solution {
    String longestPalSubstring(String s) {
        boolean table[][] = new boolean[s.length()][s.length()];
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            table[i][i] = true;
        }

        // Check for substring of length = 2
        int start = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for length greater then 2
        for (int k = 3; k <= s.length(); k++) {
            for (int i = 0; i < s.length() - k + 1; i++) {
                // Ending index of substring from
                // starting index i and k
                int j = i + k - 1;

                // Check if substring is palindrome
                if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
