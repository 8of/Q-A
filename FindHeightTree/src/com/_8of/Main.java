package com._8of;

// Find height of the tree
// (Number of nodes along the longest path)

public class Main {

    private static int findTreeHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int height = 0;
        // extra height = 1 for current node
        height += Math.max(findTreeHeight(node.getLeft()), findTreeHeight(node.getRight())) + 1;
        return height;
    }

    public static void main(String[] args) {
        Node node00 = new Node(5);

        Node node10 = new Node(3);
        Node node11 = new Node(10);
        node00.setLeft(node10);;
        node00.setRight(node11);

        Node node20 = new Node(1);
        Node node21 = new Node(4);
        node10.setLeft(node20);
        node10.setRight(node21);

        Node node22 = new Node(7);
        Node node23 = new Node(12);
        node11.setLeft(node22);
        node11.setRight(node23);

        Node node30 = new Node(14);
        node23.setRight(node30);

        System.out.println(findTreeHeight(node00)); // 4
    }
}
