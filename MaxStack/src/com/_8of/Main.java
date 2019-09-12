package com._8of;

public class Main {

    public static void main(String[] args) {
        MaxStack s = new MaxStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(2);
        System.out.println(s.max()); // 3
        s.pop();
        s.pop();
        System.out.println(s.max()); // 2
        s.pop();
        s.pop();
        System.out.println(s.max()); // -1
    }
}
