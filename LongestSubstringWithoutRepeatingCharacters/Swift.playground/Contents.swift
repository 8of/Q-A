import Cocoa

// Given a string, find the length of the longest substring without repeating characters.
// final class Solution {
//    func lengthOfLongestSubstring(s: String) -> Int {
//        ...
//    }
// }

// O(n^3)
final class Solution1 {
    func lengthOfLongestSubstring(s: String) -> Int {
        var substrings = [String]()
        let chars = Array(s)
        for i in 0..<chars.count-1 {
            var currentSubstring = ""
            for j in i..<chars.count {
                currentSubstring = "\(currentSubstring)\(chars[j])"
                substrings.append(currentSubstring)
            }
        }
        var maxLength = 1
        for substring in substrings {
            var chars = [Character: Bool]()
            var hasRepeatChars = false
            for char in substring {
                if (chars[char] == nil) {
                    chars[char] = true
                } else {
                    hasRepeatChars = true
                    break
                }
            }
            if (!hasRepeatChars) {
                maxLength = max(maxLength, substring.count)
            }
        }
        return maxLength
    }
}

// O(n)
final class Solution2 {
    func lengthOfLongestSubstring(s: String) -> Int {
        let chars = Array(s)
        var visited = [String.Element : Int]()
        var maxLength = 1
        var currentLength = 1
        var currentSubstringStartIndex = 0
        for (index, char) in chars.enumerated() {
            if let visitedIndex = visited[char] {
                if (visitedIndex > currentSubstringStartIndex) {
                    maxLength = max(maxLength, currentLength)
                    currentSubstringStartIndex = visitedIndex + 1
                    currentLength = index - visitedIndex
                } else {
                    currentLength = currentLength + 1
                    maxLength = max(maxLength, currentLength)
                }
            } else {
                currentLength = currentLength + 1
            }
            visited[char] = index
        }
        maxLength = max(maxLength, currentLength)
        return maxLength
    }
}

let answer = Solution2().lengthOfLongestSubstring(s: "abrkaabcdefghijjxxx")
print(answer)
