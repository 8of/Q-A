package com._8of;

// Implement a class for a stack that supports all the regular functions (push, pop)
// and an additional function of max() which returns the maximum element in the stack (return None if the stack is empty).
// Each method should run in constant time.
//
//class MaxStack:
//def __init__(self):
//# Fill this in.
//
//def push(self, val):
//# Fill this in.
//
//def pop(self):
//# Fill this in.
//
//def max(self):
//# Fill this in.
//
//s = MaxStack()
//s.push(1)
//s.push(2)
//s.push(3)
//s.push(2)
//print s.max()
//# 3
//s.pop()
//s.pop()
//print s.max()
//# 2

final class MaxStack {
    private Node node;

    void push(int val) {
        int maxSoFar = val;
        if (this.node != null) {
            maxSoFar = Math.max(maxSoFar, this.node.getMaxSoFar());
        }
        Node node = new Node(val, maxSoFar);
        node.setNext(this.node);
        this.node = node;
    }

    int pop() {
        int value = -1; // -1 instead of 0
        if (node != null) {
            value = node.getValue();
            node = node.getNext();
        }
        return value;
    }

    int max() {
        if (node == null) {
            return -1; // -1 instead of 0
        }
        return node.getMaxSoFar();
    }
}
