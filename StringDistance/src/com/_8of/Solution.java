package com._8of;

// Given two strings, determine the edit distance between them.
// The edit distance is defined as the minimum number of edits (insertion, deletion, or substitution)
// needed to change one string to the other.

// For example, "biting" and "sitting" have an edit distance of 2 (substitute b for s, and insert a t).

// Here's the signature:

// def distance(s1, s2):
//   # Fill this in.

// print distance('biting', 'sitting')
// # 2

final class Solution  {

    static int distance(String s1, String s2) {
        return editDist(s1, s2, s1.length(), s2.length());
    }

    static int editDist(String str1 , String str2 , int m ,int n) {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return editDist(str1, str2, m-1, n-1);

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        int insert = editDist(str1,  str2, m, n-1);
        int delete = editDist(str1,  str2, m-1, n);
        int replace = editDist(str1,  str2, m-1, n-1);
        return 1 + Math.min(Math.min(insert, delete), replace);
    }

}
