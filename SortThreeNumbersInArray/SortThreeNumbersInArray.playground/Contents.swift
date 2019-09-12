import Cocoa

// Given a list of numbers with only 3 unique numbers (1, 2, 3), sort the list in O(n) time.

// Example 1:
// Input: [3, 3, 2, 1, 3, 2, 1]
// Output: [1, 1, 2, 2, 3, 3, 3]
// def sortNums(nums):
//   # Fill this in.

// print sortNums([3, 3, 2, 1, 3, 2, 1])
// # [1, 1, 2, 2, 3, 3, 3]

// Challenge: Try sorting the list using constant space.

func sort(nums: [Int]) -> [Int] {
    var ones = 0
    var twos = 0
    var threes = 0

    for num in nums {
        switch num {
        case 1:
            ones = ones + 1;
        case 2:
            twos = twos + 1;
        case 3:
            threes = threes + 1;
        default:
            fatalError("Only 1, 2, 3 numbers")
        }
    }

    let sortedArray = Array(repeating: 1, count: ones) + Array(repeating: 2, count: twos) + Array(repeating: 3, count: threes)
    return sortedArray
}

//print(sort(nums: [3, 3, 2, 1, 3, 2, 1]))

func sortWithConstantSpace(nums: inout [Int]) -> [Int] {
    var index = 0
    var iterateCounts = 0
    while (index < nums.count && iterateCounts <= nums.count) {
        switch nums[index] {
        case 1:
            nums.remove(at: index)
            nums.insert(1, at: 0)
            index = index + 1
        case 3:
            nums.remove(at: index)
            nums.append(3)
        default:
            index = index + 1
        }
        iterateCounts = iterateCounts + 1;
    }

    return nums
}

var nums = [3, 3, 2, 1, 3, 2, 1]

print(sortWithConstantSpace(nums: &nums))

