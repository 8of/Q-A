package com._8of;

// Given a linked list of integers,
// Remove all consecutive nodes that sum up to 0

import java.util.*;

public class Main {

    private static Node removeConsecutiveSumToZero(Node head) {
        if (head == null) {
            return null;
        }

        List<Integer> values = new ArrayList<>();
        Node current = head;

        while (current != null) {
            values.add(current.getVal());
            current = current.getNext();
        }

        Set<Integer> nodesToRemove = new HashSet<>();

        int lastIndex = values.size() - 1;
        while (lastIndex > 0) {
            int sum = 0;
            for (int i = lastIndex; i >= 0; i--) {
                sum += values.get(i);
                if (sum == 0) {
                    for (int j = lastIndex; j >= i; j--) {
                        nodesToRemove.add(j);
                    }
                    lastIndex = i;
                    break;
                }
            }
            lastIndex--;
        }

        Node currentHead = head;
        current = head;
        int currentIndex = 0;
        Node prev = null;
        while (current != null) {
            if (nodesToRemove.contains(currentIndex)) {
                if (currentHead.equals(current)) {
                    currentHead = current.getNext();
                }
                if (prev != null) {
                    prev.setNext(current.getNext());
                }
            } else {
                prev = current;
            }
            current = current.getNext();
            currentIndex++;
        }

        return currentHead;
    }

    private static void printNodes(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.getVal() + "->");
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        Node node0 = new Node(10);
        Node node1 = new Node(5);
        Node node2 = new Node(-3);
        Node node3 = new Node(-3);
        Node node4 = new Node(1);
        Node node5 = new Node(4);
        Node node6 = new Node(-4);
        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

       Node node = removeConsecutiveSumToZero(node0);
       printNodes(node);
    }
}
