import Cocoa

//Given an integer k and a binary search tree, find the floor (less than or equal to) of k, and the ceiling (larger than or equal to) of k. If either does not exist, then print them as None.
//
//Here is the definition of a node for the tree.
//
//class Node:
//def __init__(self, value):
//self.left = None
//self.right = None
//self.value = value
//
//def findCeilingFloor(root_node, k, floor=None, ceil=None):
//# Fill this in.
//
//root = Node(8)
//root.left = Node(4)
//root.right = Node(12)
//
//root.left.left = Node(2)
//root.left.right = Node(6)
//
//root.right.left = Node(10)
//root.right.right = Node(14)
//
//print findCeilingFloor(root, 5)
//# (4, 6)

class Node {
    let value: Int
    var left: Node?
    var right: Node?

    init(_ value: Int) {
        self.value = value
    }
}

class Solution {
    static func findCeilingFloor(root: Node, k: Int) -> (String, String) {
        let (floor, ceiling) = findCeilingFloor(root: root)
        let stringFloor = (floor <= k) ? String(floor) : "None"
        let stringCeiling = (ceiling >= k) ? String(ceiling) : "None"
        return (stringFloor, stringCeiling)
    }

    private static func findCeilingFloor(root: Node?) -> (Int, Int) {
        guard let root = root else { return (Int.max, Int.min) }
        let (floorLeft, ceilLeft) = findCeilingFloor(root: root.left)
        let (floorRight, ceilRight) = findCeilingFloor(root: root.right)
        let newFloor = min(min(floorLeft, floorRight), root.value)
        let newCeil = max(max(ceilLeft, ceilRight), root.value)
        print(root.value, newFloor, newCeil)
        return (newFloor, newCeil)
    }
}

let root = Node(8)
root.left = Node(4)
root.right = Node(12)

root.left?.left = Node(2)
root.left?.right = Node(6)

root.right?.left = Node(10)
root.right?.right = Node(14)

print(Solution.findCeilingFloor(root: root, k: 5))
