package com._8of;

import java.util.ArrayList;

// Imagine you are building a compiler. Before running any code, the compiler must check that the parentheses in the program are balanced. Every opening bracket must have a corresponding closing bracket. We can approximate this using strings.

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
// - Open brackets are closed by the same type of brackets.
// - Open brackets are closed in the correct order.
// - Note that an empty string is also considered valid.

class BracketsValidator {
    static Boolean isValid(String s) {
        char[] brackets = s.toCharArray();
        ArrayList<Character> processingBrackets = new ArrayList<>();
        for (char bracket : brackets) {
            if (isClosingBracket(bracket)) {
                Boolean isPairOfBracketsMatches = !processingBrackets.isEmpty()
                        && isOpposite(processingBrackets.get(processingBrackets.size() - 1), bracket);
                if (isPairOfBracketsMatches) {
                    int lastProcessingIndex = processingBrackets.size() - 1;
                    processingBrackets.remove(lastProcessingIndex);
                } else {
                    return false;
                }
            } else {
                processingBrackets.add(bracket);
            }
        }
        return processingBrackets.isEmpty();
    }

    static private Boolean isClosingBracket(char bracket) {
        switch (bracket) {
            case ')':
            case '}':
            case ']':
                return true;
            default:
                return false;
        }
    }

    static private Boolean isOpposite(char opening, char closing) {
        switch (closing) {
            case ')': return opening == '(';
            case '}': return opening == '{';
            case ']': return opening == '[';
            default: return false;
        }
    }
}
