package com._8of;

// You are given set of integers an unordered binary tree
// Use an array sorting routine to transform tree into a heap
// that uses balanced binary tree as its underlying data structure

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Main {

    private static Node heapifyBinaryTree(Node node) {
        if (node == null) {
            return null;
        }
        ArrayList<Node> nodes = sortedArrayFromTree(node);
        // need to create e heap (min or max, doesn't matter)
        for (int i = 0; i < nodes.size(); i++) {
            int left = 2*i + 1;
            int right = left + 1;
            Node newLeft = left >= nodes.size() ? null : nodes.get(left);
            Node newRight = right >= nodes.size() ? null : nodes.get(right);
            nodes.get(i).setLeft(newLeft);
            nodes.get(i).setRight(newRight);
        }
        return nodes.get(0);
    }

    private static ArrayList<Node> sortedArrayFromTree(Node node) {
        ArrayList<Node> array = new ArrayList<>();
        if (node == null) {
            return array;
        }
        Node current = node;
        Stack<Node> toProcess = new Stack<>();
        while (current != null) {
            array.add(current);
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
        Collections.sort(array);
        return array;
    }

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

    public static void main(String[] args) {
        Node node00 = new Node(14);

        Node node10 = new Node(10);
        Node node11 = new Node(12);
        node00.setLeft(node10);;
        node00.setRight(node11);

        Node node20 = new Node(4);
        Node node21 = new Node(22);
        node10.setLeft(node20);
        node10.setRight(node21);

        Node node30 = new Node(8);
        Node node31 = new Node(20);
        node21.setLeft(node30);
        node21.setRight(node31);

        Node node = heapifyBinaryTree(node00);
        preorderTreeTraversal(node);
    }
}
