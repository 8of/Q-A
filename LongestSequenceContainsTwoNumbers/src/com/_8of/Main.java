package com._8of;

// Given a sequence of numbers, find the longest sequence that contains only 2 unique numbers.

// Example:
// Input: [1, 3, 5, 3, 1, 3, 1, 5]
// Output: 4
// The longest sequence that contains just 2 unique numbers is [3, 1, 3, 1]

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    static int findSequence(int[] numbers) {
        if (numbers.length < 3) {
            return numbers.length;
        }

        // store start index of current substrings
        // store longest substring length so far
        // store unique numbers
        // when unique numbers <= 2:
        // - got to next element
        // when unique numbers > 2:
        // - check max length
        // - store new max if needed
        // - shift start index until unique numbers <= 2 again

        Map<Integer, Integer> unique = new HashMap<>();
        int startIndex = 0;
        int max = 0;

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (!unique.containsKey(number)) {
                unique.put(number, 0);
            }
            unique.put(number, unique.get(number) + 1);

            if (unique.size() > 2) {
                // shift "window"
                while (unique.size() > 2) {
                    int numberToDelete = numbers[startIndex];
                    unique.replace(numberToDelete, unique.get(numberToDelete) - 1);
                    if (unique.get(numberToDelete) == 0) {
                        unique.remove(numberToDelete);
                    }
                    startIndex++;
                }
            } else {
                // update max
                max = Math.max(max, i - startIndex + 1);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 5, 3, 1, 3, 1, 5};
        System.out.println(findSequence(numbers));
    }
}
