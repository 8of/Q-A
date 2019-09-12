import Cocoa

// Given a list of numbers, where every number shows up twice except for one number, find that one number.

// Example:
// Input: [4, 3, 2, 4, 1, 3, 2]
// Output: 1
// Here's the function signature:

// def singleNumber(nums):
//   # Fill this in.

// print singleNumber([4, 3, 2, 4, 1, 3, 2])
// # 1

// Challenge: Find a way to do this using O(1) memory.

final class Solution {
    static func singleNumber(_ numbers: inout [Int]) -> Int {
        numbers.sort()
        for (index, number) in numbers.enumerated() {
            if (index > 0 && numbers[index-1] != number) && (index < numbers.count-2 && numbers[index+1] != number) {
                return number
            } else if (index == 0 && numbers[index + 1] != number) {
                return number
            } else if (index == numbers.count-1 && numbers[index-1] != number) {
                return number
            }
        }
        // Will never happen
        return -1
    }
}

var numbers0 = [4, 3, 2, 4, 1, 3, 2]
print(Solution.singleNumber(&numbers0))

var numbers1 = [4, 3, 1, 4, 1, 3, 2]
print(Solution.singleNumber(&numbers1))

var numbers2 = [4, 3, 1, 2, 1, 3, 2]
print(Solution.singleNumber(&numbers2))
