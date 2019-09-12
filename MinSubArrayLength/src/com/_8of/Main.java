package com._8of;

// Given an array of n positive integers and a positive integer s,
// find the minimal length of a contiguous subarray of which the sum ≥ s.
// If there isn't one, return 0 instead.

// Example:
// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: the subarray [4,3] has the minimal length under the problem constraint.

public class Main {

    private static int minSubArrayLen(int[] nums, int s) {
        // check corner cases
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // store min length that exceeds S so far
        // store current sum so far
        // store start index of current subarray
        int minLength = 0;
        int startIndex = 0;
        int currentSum = 0;

        // "shift" end index of current subarray
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            currentSum += num;

            // when exceeds S:
            if (currentSum >= s) {
                int currentLength = i - startIndex + 1;
                if (minLength == 0) {
                    // first time length is 0, just assign it
                    minLength = currentLength;
                } else {
                    // - check current length and min length - update if needed
                    minLength = Math.min(minLength, currentLength);
                }
                while (currentSum >= s) {
                    // If after next startIndex increment current sum will be too small
                    if (currentSum - nums[startIndex] < s) {
                        int newLength = i - startIndex + 1;
                        minLength = Math.min(minLength, newLength);
                    }

                    // - shift left part of subarray "window" until it's smaller then S
                    currentSum -= nums[startIndex];

                    // - recalculate current sum
                    startIndex++;
                }
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(nums, 7));
    }
}
