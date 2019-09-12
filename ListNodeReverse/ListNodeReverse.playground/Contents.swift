import Cocoa

// Hi, here's your problem today. This problem was recently asked by Google:

// Given a singly-linked list, reverse the list. This can be done iteratively or recursively. Can you get both solutions?

// Example:
// Input: 4 -> 3 -> 2 -> 1 -> 0 -> NULL
// Output: 0 -> 1 -> 2 -> 3 -> 4 -> NULL
// class ListNode(object):
//   def __init__(self, x):
//     self.val = x
//     self.next = None

//   # Function to print the list
//   def printList(self):
//     node = self
//     output = ''
//     while node != None:
//       output += str(node.val)
//       output += " "
//       node = node.next
//     print(output)

//   # Iterative Solution
//   def reverseIteratively(self, head):
//     # Implement this.

//   # Recursive Solution
//   def reverseRecursively(self, head):
//     # Implement this.

// # Test Program
// # Initialize the test list:
// testHead = ListNode(4)
// node1 = ListNode(3)
// testHead.next = node1
// node2 = ListNode(2)
// node1.next = node2
// node3 = ListNode(1)
// node2.next = node3
// testTail = ListNode(0)
// node3.next = testTail

// print("Initial list: ")
// testHead.printList()
// # 4 3 2 1 0
// testHead.reverseIteratively(testHead)
// #testHead.reverseRecursively(testHead)
// print("List after reversal: ")
// testTail.printList()
// # 0 1 2 3 4

final class ListNode {
    let value: Int
    var next: ListNode?

    init(value: Int, next: ListNode? = nil) {
        self.value = value
        self.next = next
    }

    func reverseIteratively(head: ListNode) {
        var prev: ListNode?
        var current: ListNode? = head
        while (current != nil) {
            let temp = current?.next
            current?.next = prev
            prev = current
            current = temp
        }
    }

    func reverseRecursively(head: ListNode?, prevNode: ListNode? = nil) {
        guard let current = head else { return }
        let oldNext = current.next
        current.next = prevNode
        reverseRecursively(head: oldNext, prevNode: current)
    }

    func printList(head: ListNode) {
        var current: ListNode? = head
        var output = ""
        while (current != nil) {
            output = "\(output)\(current!.value) "
            current = current?.next
        }
        print(output)
    }
}

let nodeTail0 = ListNode(value: 0)
let node03 = ListNode(value: 1, next: nodeTail0)
let node02 = ListNode(value: 2, next: node03)
let node01 = ListNode(value: 3, next: node02)
let node00 = ListNode(value: 4, next: node01)

node00.reverseIteratively(head: node00)
nodeTail0.printList(head: nodeTail0)

let nodeTail1 = ListNode(value: 0)
let node13 = ListNode(value: 1, next: nodeTail1)
let node12 = ListNode(value: 2, next: node13)
let node11 = ListNode(value: 3, next: node12)
let node10 = ListNode(value: 4, next: node11)

node10.reverseRecursively(head: node10)
nodeTail1.printList(head: nodeTail1)
