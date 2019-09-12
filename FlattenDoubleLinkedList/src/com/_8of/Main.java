package com._8of;

public class Main {
    public static void main(String[] args) {

        DoubleLinkedList<Integer> dll0 = new DoubleLinkedList<>();
        DoubleLinkedList<Integer> dll1 = new DoubleLinkedList<>();

        Node<Integer> n00 = new Node<>(5);
        Node<Integer> n01 = new Node<>(33);
        Node<Integer> n02 = new Node<>(17);
        n00.setNext(n01);
        n01.setNext(n02);

        Node<Integer> n10 = new Node<>(6);
        Node<Integer> n11 = new Node<>(25);
        n10.setNext(n11);

        dll1.setHead(n10);
        n00.setChild(dll1);
        dll0.setHead(n00);

        dll0.print();
        dll0.flatten();
        dll0.print();
    }
}
