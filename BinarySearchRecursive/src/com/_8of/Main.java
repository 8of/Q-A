package com._8of;

// Sorted array of numbers
// Find index of given number
// Use recursive binary search

public class Main {

    private static int binarySearch(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return bsRecursive(nums, 0, nums.length - 1, k);
    }

    private static int bsRecursive(int[] nums, int start, int end, int k) {
        if (start == end || start == end - 1) {
            if (nums[start] == k) {
                return start;
            } else if (nums[end] == k) {
                return end;
            }
            return -1;
        }

        int center = start + (end - start) / 2;

        if (nums[center] == k) {
            return center;
        } else if (nums[center] > k) {
            return bsRecursive(nums, start, center ,k);
        } else {
            return bsRecursive(nums, center, end, k);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,10,20,30,40,50,60,70,80,90};
        System.out.println(binarySearch(nums,30));
        System.out.println(binarySearch(nums,90));
    }
}
