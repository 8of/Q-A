package com._8of;

// You are given a positive integer N which represents the number of steps in a staircase.
// You can either climb 1 or 2 steps at a time. Write a function that returns the number of unique ways to climb the stairs.

// def staircase(n):
//   # Fill this in.

// print staircase(4)
// # 5
// print staircase(5)
// # 8

// Can you find a solution in O(n) time?

final class Solution {
    static int staircase(int steps) {
        if (steps <= 1) {
            return 1;
        }
        return staircase(steps-1) + staircase(steps-2);
    }
}
