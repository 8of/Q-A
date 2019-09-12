// Hi, here's your problem today. This problem was recently asked by Twitter:

// A palindrome is a sequence of characters that reads the same backwards and forwards. Given a string, s, find the longest palindromic substring in s.

// Example:
// Input: "banana"
// Output: "anana"

// Input: "million"
// Output: "illi"
// class Solution:
//     def longestPalindrome(self, s):
//       # Fill this in.

// # Test program
// s = "tracecars"
// print(str(Solution().longestPalindrome(s)))
// # racecar

import Cocoa

// O(n^3)
final class Solution {
    func longestPalindrome(s: String) -> String {
        let chars = Array(s)
        var substrings = Set<String>()
        for i in 0..<chars.count-1 {
            var currentSubstring = "\(chars[i])"
            for j in i+1..<chars.count {
                currentSubstring = "\(currentSubstring)\(chars[j])"
                substrings.insert(currentSubstring)
            }
        }
        var longestPalindrom = ""
        for substring in substrings {
            let substringChars = Array(substring)
            var isPalindrome = true
            for i in 0..<substringChars.count/2 {
                if (substringChars[i] != substringChars[substringChars.count-1-i]) {
                    isPalindrome = false
                    break
                }
            }
            if (isPalindrome && substring.count > longestPalindrom.count) {
                longestPalindrom = substring
            }
        }

        return longestPalindrom
    }
}

let answer0 = Solution().longestPalindrome(s: "banana")
print(answer0)

let answer1 = Solution().longestPalindrome(s: "million")
print(answer1)

let answer2 = Solution().longestPalindrome(s: "tracecars")
print(answer2)
