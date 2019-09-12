import Cocoa

//You are given the root of a binary tree. Invert the binary tree in place. That is, all left children should become right children, and all right children should become left children.
//
//Example:
//
//a
/// \
//b   c
/// \  /
//d   e f
//
//The inverted version of this tree is as follows:
//
//a
/// \
//c  b
//\  / \
//f e  d
//
//Here is the function signature:
//
//class Node:
//def __init__(self, value):
//self.left = None
//self.right = None
//self.value = value
//def preorder(self):
//print self.value,
//if self.left: self.left.preorder()
//if self.right: self.right.preorder()
//
//def invert(node):
//# Fill this in.
//
//root = Node('a')
//root.left = Node('b')
//root.right = Node('c')
//root.left.left = Node('d')
//root.left.right = Node('e')
//root.right.left = Node('f')
//
//root.preorder()
//# a b d e c f
//print "\n"
//invert(root)
//root.preorder()
//# a c f b e d

final class Node {
    let value: String
    var left: Node?
    var right: Node?

    init(_ value: String) {
        self.value = value
    }

    func preorder() {
        print(value)
        if let left = left {
            left.preorder()
        }
        if let right = right {
            right.preorder()
        }
    }

    func invert(_ root: Node?) {
        guard let root = root else { return }
        let left = root.left
        let right = root.right
        root.left = right
        root.right = left
        invert(root.left)
        invert(root.right)
    }
}

let root = Node("a")
root.left = Node("b")
root.right = Node("c")
root.left?.left = Node("d")
root.left?.right = Node("e")
root.right?.left = Node("f")

root.preorder()
print("")
root.invert(root)
root.preorder()
