package com._8of;

final class Node {
    private int value;
    private Node next;
    private int maxSoFar;

    Node(int value, int maxSoFar) {
        this.value = value;
        this.maxSoFar = maxSoFar;
    }

    int getValue() {
        return value;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }

    int getMaxSoFar() {
        return maxSoFar;
    }
}
