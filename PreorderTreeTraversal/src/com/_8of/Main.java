package com._8of;

// Perform preorder traversal of a binary search tree
// Now try to solve task without recursion

import java.util.Stack;

public class Main {

    private static void preorderTreeTraversal(Node node) {
        if (node == null) {
            return;
        }

        // If we need inorder or postorder traversal:
        // We can change the order of theese three calls
        System.out.print(node.getValue() + "->");
        preorderTreeTraversal(node.getLeft());
        preorderTreeTraversal(node.getRight());
    }

    private static void preorderTreeTraversalNoRecursion(Node node) {
        if (node == null) {
            return;
        }
        Node current = node;
        Stack<Node> toProcess = new Stack<>();
        while (current != null) {
            System.out.print(current.getValue() + "->");
            if (current.getRight() != null) {
                toProcess.push(current.getRight());
            }
            if (current.getLeft() != null) {
                current = current.getLeft();
            } else {
                if (!toProcess.empty()) {
                    current = toProcess.pop();
                } else {
                    current = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node node00 = new Node(100);

        Node node10 = new Node(50);
        Node node11 = new Node(150);
        node00.setLeft(node10);;
        node00.setRight(node11);

        Node node20 = new Node(25);
        Node node21 = new Node(75);
        node10.setLeft(node20);
        node10.setRight(node21);

        Node node22 = new Node(125);
        Node node23 = new Node(175);
        node11.setLeft(node22);
        node11.setRight(node23);

        Node node30 = new Node(110);
        node22.setLeft(node30);

        preorderTreeTraversal(node00);
        System.out.println();

        preorderTreeTraversalNoRecursion(node00);
        System.out.println();
    }
}
