package com._8of;

public class Main {

    public static void main(String[] args) {
        Boolean answer0 = BracketsValidator.isValid("((()))");
        System.out.println("((())) -> " + answer0);
        Boolean answer1 = BracketsValidator.isValid("[()]{}");
        System.out.println("[()]{} -> " + answer1);
        Boolean answer2 = BracketsValidator.isValid("({[)]");
        System.out.println("({[)] -> " + answer2);
        Boolean answer3 = BracketsValidator.isValid("()(){(())");
        System.out.println("()(){(()) -> " + answer3);
        Boolean answer4 = BracketsValidator.isValid("");
        System.out.println("'' -> " + answer4);
        Boolean answer5 = BracketsValidator.isValid("([{}])()");
        System.out.println("([{}])() -> " + answer5);
    }
}
