package com._8of;

// Given a mathematical expression with just single digits, plus signs, negative signs, and brackets, evaluate the expression.
// Assume the expression is properly formed.

// Example:
// Input: - ( 3 + ( 2 - 1 ) )
// Output: -4
// Here's the function signature:

// def eval(expression):
//   # Fill this in.

// print eval('- (3 + ( 2 - 1 ) )')
// # -4

import java.util.ArrayList;
import java.util.List;

public class Main {

    static int evaluate(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }
        int answer = 0;
        int index = 0;
        String noSpaces = expression.replace(" ", "");
        char[] chars = noSpaces.toCharArray();

        int nextMultiplier = 1;
        while (index < chars.length) {
            char c = chars[index];
            switch (c) {
                case '+': {
                    nextMultiplier = 1;
                    index++;
                    break;
                }
                case '-': {
                    nextMultiplier = -1;
                    index++;
                    break;
                }
                case '(': {
                    int end = index;
                    int opened = 0;
                    int closed = 0;
                    for (int j = index; j < chars.length; j++) {
                        char innerC = chars[j];
                        if (innerC == '(') {
                            opened++;
                        } else if (innerC == ')') {
                            closed++;
                        }
                        if (opened == closed) {
                            String substring = noSpaces.substring(index + 1, j);
                            answer += nextMultiplier * evaluate(substring);
                            nextMultiplier = 1;
                            index = j + 1;
                        }
                    }
                    break;
                }
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': {
                    answer = answer + nextMultiplier * Integer.parseInt(String.valueOf(c));
                    nextMultiplier = 1;
                    index++;
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(evaluate("- (3 + ( 2 - 1 ) )"));
    }
}
