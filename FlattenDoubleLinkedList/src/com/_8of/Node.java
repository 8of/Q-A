package com._8of;

class Node<T> {
    private Node<T> next;
    private Node<T> prev;
    private DoubleLinkedList<T> child;
    private T value;

    Node(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
        if (next.getPrev() != null && !next.getPrev().equals(this)) {
            next.setPrev(this);
        }
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
        if (prev.getNext() != null && !prev.getNext().equals(this)) {
            prev.setNext(this);
        }

    }

    public DoubleLinkedList<T> getChild() {
        return child;
    }

    public void setChild(DoubleLinkedList<T> child) {
        this.child = child;
    }

    public T getValue() {
        return value;
    }

    Node<T> flatten() {
        if (child == null) {
            return this;
        } if (child.getHead() == null) {
            setChild(null);
            return this;
        }

        Node<T> next = getNext();
        setNext(child.getHead());
        Node<T> last = child.flatten();
        last.setNext(next);

        return last;
    }
}
