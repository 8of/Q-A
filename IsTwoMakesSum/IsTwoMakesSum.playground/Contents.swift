import Cocoa

// You are given a list of numbers, and a target number k. Return whether or not there are two numbers in the list that add up to k.

// Example:
// Given [4, 7, 1 , -3, 2] and k = 5,
// return true since 4 + 1 = 5.

// def two_sum(list, k):
//   # Fill this in.

// print two_sum([4,7,1,-3,2], 5)
// # True

// Try to do it in a single pass of the list.

class Solution {
    static func isTwoMakesSum(_ numbers: [Int], target: Int) -> Bool {
        var leftovers = [Int: Bool]()
        for number in numbers {
            guard leftovers[number] == nil else { return true }
            let leftover = number - target
            leftovers[leftover] = true
        }
        return false
    }
}

print(Solution.isTwoMakesSum([4, 7, 1 , -3, 2], target: 5))
