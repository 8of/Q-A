package com._8of;

// Given two values of two nodes in a tree
// Find the lowest common ancestor
// Assume both values exist in a tree

public class Main {

    private static Node findLowestCommonAncestor(Node node, int v1, int v2) {
        if (node == null) {
            return null;
        }

        // bst so ancestor should be either "between" value nodes (one of them on the left, another one on the right)
        // or above both of them (both of element on the same side)

        // traverse until the "split point"
        Node current = node;
        while (current.getValue() > v1 && current.getValue() > v2 || current.getValue() < v1 && current.getValue() < v2) {
            // In situation when we find out left or right element is one of our elements to find,
            // And both elements on one side of the current node
            // This node is our answer node
            boolean isLeftOurNode = current.getLeft() != null && current.getLeft().getValue() == v1 || current.getLeft().getValue() == v2;
            boolean isRightOurNode = current.getRight() != null && current.getRight().getValue() == v1 || current.getRight().getValue() == v2;
            boolean isFoundAncestor = isLeftOurNode || isRightOurNode;
            if (isFoundAncestor) {
                return current;
            }
            if (current.getValue() > v1) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        // found split point
        return current;
    }

    public static void main(String[] args) {
        Node node00 = new Node(20);

        Node node10 = new Node(8);
        Node node11 = new Node(22);
        node00.setLeft(node10);;
        node00.setRight(node11);

        Node node20 = new Node(4);
        Node node21 = new Node(12);
        node10.setLeft(node20);
        node10.setRight(node21);

        Node node30 = new Node(10);
        Node node31 = new Node(14);
        node21.setLeft(node30);
        node21.setRight(node31);

        System.out.println(findLowestCommonAncestor(node00, 4, 14).getValue()); // 8
        System.out.println(findLowestCommonAncestor(node00, 10, 14).getValue()); // 12
        System.out.println(findLowestCommonAncestor(node00, 12, 14).getValue()); // 8
    }
}
