package com._8of;

import java.util.*;

// Few friends go on a tour.
// The travel and other expenses are  paid by some of the friends.
// So the problem is to design a program to equally divide the expenses among them and thus display as output who owes money to whom.
// Input: First line consists of the comma separated list of name of the friends. Next lines contain the money spent by each friend during the voyage.
// Output: Output should contain the list of transactions required among the friends so that the total expense is uniformly distributed among them.
// Example:- Sample Input: A,B,C,D A 300 Snacks C 100 Tickets D 200 Taxi Sample Output: B -> A 150 C -> D 50
// (Long coding problem) [Class and other OOP concepts expected in code]

public class Main {

    public static void main(String[] args) {
        Collection<String> people = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        Collection<Transaction> costs = new ArrayList<>(Arrays.asList(
                new Transaction("A", "Snacks", 300),
                new Transaction("C", "tickets", 100),
                new Transaction("D", "Taxi", 200)
        ));

        List<String> solution = new CostsSplitter().splitCosts(people, costs);
        System.out.println(solution);
    }
}
