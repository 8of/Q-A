package com._8of;

// You 2 integers n and m representing an n by m grid,
// determine the number of ways you can get from the top-left to the bottom-right of the matrix y going only right or down.
//
// Example:
// n = 2, m = 2
//
// This should return 2, since the only possible routes are:
// Right, down
// Down, right.

public class Main {

    private static int numberWaysTraverseMatrix(int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        } else if (n == 1 && m == 1) {
            return 1;
        }

        int newNCount = n == 1 ? 0 : numberWaysTraverseMatrix(n-1,m);
        int newMCount = m == 1 ? 0 : numberWaysTraverseMatrix(n,m-1);

        return newNCount + newMCount;
    }

    public static void main(String[] args) {
        System.out.println(numberWaysTraverseMatrix(1,1)); // 1
        System.out.println(numberWaysTraverseMatrix(1,2)); // 1
        System.out.println(numberWaysTraverseMatrix(2,2)); // 2
        System.out.println(numberWaysTraverseMatrix(2,3)); // 3
        System.out.println(numberWaysTraverseMatrix(3,2)); // 3
        System.out.println(numberWaysTraverseMatrix(3,3)); // 6
        System.out.println(numberWaysTraverseMatrix(3,4)); // 10

        // 1x1 -> 0
        // 1x2 => 1
        // 2x2 -> 2
        // 2x3 -> 3
        // 3x3 -> 6
        // 3x4 -> 10
    }
}
