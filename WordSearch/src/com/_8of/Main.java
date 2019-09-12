package com._8of;

// You are given a 2D array of characters, and a target string.
// Return whether or not the word target word exists in the matrix.
// Unlike a standard word search, the word must be either going left-to-right, or top-to-bottom in the matrix.

// Example:

// [['F', 'A', 'C', 'I'],
//  ['O', 'B', 'Q', 'P'],
//  ['A', 'N', 'O', 'B'],
//  ['M', 'A', 'S', 'S']]

// Given this matrix, and the target word FOAM, you should return true, as it can be found going up-to-down in the first column.

public class Main {

    static boolean wordSearch(char[][] c, String s) {

        for (int i = 0; i < c[0].length; i++) {
            StringBuilder builderH = new StringBuilder();
            StringBuilder builderV = new StringBuilder();
            for (int j = 0; j < c.length; j++) {
                builderH.append(c[i][j]);
                builderV.append(c[j][i]);
                boolean isStringFound = (builderH.toString().equals(s) || builderV.toString().equals(s));
                if (isStringFound) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
	    char[][] characters = {{'F','A','C','I'},{'O','B','Q','P'},{'A','N','O','B'},{'M','A','S','S'}};
        System.out.println(wordSearch(characters, "FOAM"));
    }
}
