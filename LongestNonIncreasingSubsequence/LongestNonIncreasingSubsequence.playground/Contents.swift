import Cocoa

// Найти максимальную неувеличивающуюся  последовательность в массиве

struct Interval {
    let start: Int
    let end: Int
}

class SolutionArray {
    static func maxNonIncreasingSubSequence(sequence: [Int]) -> [Int] {
        var start = 0
        var end = -1

        var previous: Int?
        var longest: Interval?

        for (index, current) in sequence.enumerated() {
            if (previous == nil) {
                previous = current
                continue
            } else if (current <= previous!) {
                end = index
            } else {
                if (longest == nil) {
                    longest = Interval(start: start, end: end)
                } else {
                    let currentLength = end - start + 1
                    let longestLength = longest!.end - longest!.start + 1
                    if (currentLength > longestLength) {
                        longest = Interval(start: start, end: end)
                    }
                }
                // Not last element
                if (index != sequence.count - 1) {
                    start = index
                } else {
                    start = -1
                }
                end = -1
            }
            previous = current
        }

        if (start != -1) {
            if (longest == nil) {
                longest = Interval(start: start, end: sequence.count - 1)
            } else {
                let currentLength = sequence.count - 1 - start + 1
                let longestLength = longest!.end - longest!.start + 1
                if (currentLength > longestLength) {
                    longest = Interval(start: start, end: end)
                }
            }
        }

        if (longest == nil) {
            return []
        }

        var subsequence = [Int]()
        for index in longest!.start...longest!.end {
            subsequence.append(sequence[index])
        }
        return subsequence
    }
}

print(SolutionArray.maxNonIncreasingSubSequence(sequence: [5, 4, 3, 2, 3]))
print(SolutionArray.maxNonIncreasingSubSequence(sequence: [5, 4, 3, 2, 1]))
print(SolutionArray.maxNonIncreasingSubSequence(sequence: [1, 4, 3, 2, 1]))
print(SolutionArray.maxNonIncreasingSubSequence(sequence: [1, 4, 1, 2, 1]))
print(SolutionArray.maxNonIncreasingSubSequence(sequence: [1, 4, 1, 2, 1, 0]))
print(SolutionArray.maxNonIncreasingSubSequence(sequence: [1, 4, 1, 2, 1, 0, 0]))
