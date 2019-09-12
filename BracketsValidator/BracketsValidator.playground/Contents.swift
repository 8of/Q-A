import Cocoa

// Imagine you are building a compiler. Before running any code, the compiler must check that the parentheses in the program are balanced. Every opening bracket must have a corresponding closing bracket. We can approximate this using strings.

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
// - Open brackets are closed by the same type of brackets.
// - Open brackets are closed in the correct order.
// - Note that an empty string is also considered valid.

final class BracketsValidator {
  func isValid(s: String) -> Bool {
    let brackets = Array(s)
    var processingBrackets = [String.Element]()
    for bracket in brackets {
      if (isClosing(bracket)) {
        guard !processingBrackets.isEmpty else { return false }
        let lastProcessingBracket = processingBrackets.removeLast()
        guard isOpposite(lastProcessingBracket, bracket) else { return false }
      } else {
        processingBrackets.append(bracket)
      }
    }
    return processingBrackets.isEmpty
  }

  private func isClosing(_ bracket: String.Element) -> Bool {
    switch bracket {
      case ")", "}", "]":
      return true
      default:
      return false
    }
  }

  private func isOpposite(_ opening: String.Element, _ closing: String.Element) -> Bool {
    switch closing {
      case ")":
      return opening == "("
      case "}":
      return opening == "{"
      case "]":
      return opening == "["
      default:
      return false
    }
  }
}

print("((())) ->",  BracketsValidator().isValid(s: "((()))"))
print("[()]{} ->", BracketsValidator().isValid(s: "[()]{}"))
print("({[)] ->", BracketsValidator().isValid(s: "({[)]"))
print("()(){(()) ->", BracketsValidator().isValid(s: "()(){(())"))
print("'' ->", BracketsValidator().isValid(s: ""))
print("([{}])() ->", BracketsValidator().isValid(s: "([{}])()"))
