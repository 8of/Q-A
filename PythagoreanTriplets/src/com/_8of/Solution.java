package com._8of;

// Given a list of numbers, find if there exists a pythagorean triplet in that list.
// A pythagorean triplet is 3 variables a, b, c where a^2 + b^2 = c^2

// Example:
// Input: [3, 5, 12, 5, 13]
// Output: True
// Here, 5^2 + 12^2 = 13^2.

// def findPythagoreanTriplets(nums):
//   # Fill this in.

// print findPythagoreanTriplets([3, 12, 5, 13])
// # True

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class Solution {
    static Boolean isPythagoreanTriplet(int[] numbers) {
        if (numbers.length < 3) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                for (int k = 0; k < numbers.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    Boolean isPythagorean = numbers[j]*numbers[j] + numbers[k]*numbers[k] == numbers[i]*numbers[i];
                    if (isPythagorean) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static Boolean isPythagoreanTripletSecondTry(int[] numbers) {
        if (numbers.length < 3) {
            return false;
        }

        // Squared and sorted
        List<Integer> nums = Arrays
                .stream(numbers)
                .boxed()
                .map(x -> x*x)
                .sorted()
                .collect(Collectors.toList());

        for (int i = nums.size() - 1; i > 1; i--) {
            int s = 0; // start
            int e = i - 1; // end
            while (s < e) {
                if (nums.get(s) + nums.get(e) == nums.get(i)) {
                    return true;
                } else if (nums.get(s) + nums.get(e) < nums.get(i)) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        return false;
    }
}
