package com._8of;

import java.util.HashMap;

class Solution {
    static Boolean isTwoMakesSum(int[] numbers, int target) {
        HashMap<Integer, Boolean> leftovers = new HashMap<>();
        for (int number : numbers) {
            if (leftovers.get(number) != null) {
                return true;
            }
            int leftover = number - target;
            leftovers.put(leftover, true);
        }
        return false;
    }
}
