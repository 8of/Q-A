package com._8of;

class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        if (this.getHead() == null) {
            this.head = head;
            this.tail = tail;
        } else {
            head.setNext(this.head);
            this.head.setPrev(head);
            this.head = head;
        }
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        if (this.getTail() == null) {
            setHead(tail);
        } else {
            tail.setPrev(this.tail);
            this.tail.setNext(tail);
            this.tail = tail;
        }
    }

    Node<T> flatten() {
        if (head == null) {
            return null;
        }
        Node<T> node = head;
        while (node != null) {
            Node<T> next = node.getNext();
            tail = node.flatten();
            node = next;
        }
        return tail;
    }

    void print() {
        if (head == null) {
            System.out.println("Empty linked list");
        }
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.getValue() + "->");
            node = node.getNext();
        }
        System.out.println();
    }
}
