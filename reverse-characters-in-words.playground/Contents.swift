// Get array of characters
// array of characters - array of words separated by spaces
// reverse characters in words but do not reverse words itself
// Need to replace in place, do not create another array, strings or something like that
//
// Swift solution
//
// Iterate over array
// When find 'space' char - store index (1)
// When find next 'space' char - store index (2)
// Swap characters between (1) and (2) indexes
// Continue from index (2)
// Clear stored indexes (1) and (2)

func reverseWords(input: inout [Character]) -> [Character] {
  if (input.count == 0 || input.count == 1) {
    return input
  }

  let isLastCharSpace = input[input.count-1] == " "
  if (!isLastCharSpace) {
    input.append(" ")
  }

  var current = 0
  var start: Int? = 0
  var end: Int?
  while (current < input.count) {
    if (input[current] == " ") {
      if (start != nil) {
        end = current - 1
      } else {
        start = current + 1
      }
    }

    if let startU = start, let endU = end {
      current = endU+1
      while (start! != end! && start! < end!) {
        let temp = input[end!]
        input[end!] = input[start!]
        input[start!] = temp
        start = start! + 1
        end = end! - 1
      }
      start = nil
      end = nil
    }

    current = current + 1
  }

  if (!isLastCharSpace) {
    input.remove(at: input.count-1)
  }

  return input
}

var input0: [Character] = ["T", "e", "s", " ", "T", "e", " ", "T", "e", "s", " "]
var input1: [Character] = ["T", "e", "s"]
var input2: [Character] = ["T", "e", "s", " ", "T", "t"]
var input3: [Character] = []
var input4: [Character] = ["T", "e", "s", " ", " ", "T", "t"]

print(reverseWords(input: &input0))
print(reverseWords(input: &input1))
print(reverseWords(input: &input2))
print(reverseWords(input: &input3))
print(reverseWords(input: &input4))
