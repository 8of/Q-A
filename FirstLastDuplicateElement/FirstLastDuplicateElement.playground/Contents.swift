import Cocoa

// Given a sorted array, A, with possibly duplicated elements, find the indices of the first and last occurrences of a target element, x.
// Return -1 if the target is not found.

// Example:
// Input: A = [1,3,3,5,7,8,9,9,9,15], target = 9
// Output: [6,8]

// Input: A = [100, 150, 150, 153], target = 150
// Output: [1,2]

// Input: A = [1,2,3,4,5,6,10], target = 9
// Output: [-1, -1]
// Here is a function signature example:

// class Solution:
//   def getRange(self, arr, target):
//     # Fill this in.

// # Test program
// arr = [1, 2, 2, 2, 2, 3, 4, 7, 8, 8]
// x = 2
// print(Solution().getRange(arr, x))
// # [1, 4]


// Solution outline:
// Find center of the array
// If element is bigger than target - take left subarray and repeat previos action
// If element is smaller than target - take right subarray and repeat previos action
// If element is equal to the target - go left until smaller element found
// Store start index
// Go right until end index found
// If element is not found - return [-1, -1]

final class Solution {
  func getRange(numbers: [Int], x: Int) -> [Int] {
    var prevIndex = 0
    var nextIndex = numbers.count - 1
    var centerIndex = nextCenter(prevIndex, nextIndex)

    while (centerIndex > 0) {
      let element = numbers[centerIndex]
      if (element < x) {
        prevIndex = centerIndex
      } else if (element > x) {
        nextIndex = centerIndex
      } else { // == x
        break
      }
      if (nextCenter(prevIndex, nextIndex) == centerIndex) {
        break
      }
      centerIndex = nextCenter(prevIndex, nextIndex)
    }
    if (numbers[centerIndex] != x) {
      return [-1, -1]
    }
    var startIndex = 0
    var endIndex = numbers.count - 1

    var currentIndex = centerIndex

    while (currentIndex >= 0) {
      if (numbers[currentIndex] == x) {
        if (currentIndex > 0) {
          currentIndex = currentIndex - 1
        } else {
          startIndex = 0
          break
        }
      } else {
        startIndex = currentIndex + 1
        break
      }
    }

    currentIndex = centerIndex

    while (currentIndex <= numbers.count - 1) {
      if (numbers[currentIndex] == x) {
        if (currentIndex < numbers.count - 1) {
          currentIndex = currentIndex + 1
        } else {
          endIndex = numbers.count - 1
          break
        }
      } else {
        endIndex = currentIndex - 1
        break
      }
    }

    return [startIndex, endIndex]
  }

  private func nextCenter(_ prevIndex: Int, _ nextIndex: Int) -> Int {
    return (prevIndex + nextIndex) / 2
  }
}

let answer0 = Solution().getRange(numbers: [1,3,3,5,7,8,9,9,9,15], x: 9)
print(answer0)

let answer1 = Solution().getRange(numbers: [100, 150, 150, 153], x: 150)
print(answer1)

let answer2 = Solution().getRange(numbers: [1,2,3,4,5,6,10], x: 9)
print(answer2)
