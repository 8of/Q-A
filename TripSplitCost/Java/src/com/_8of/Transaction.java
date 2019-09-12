package com._8of;

// Input and output transactions
class Transaction {
    private String from;
    private String to;
    private int amount;

    Transaction(String from, String to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    String getFrom() {
        return from;
    }

    String getTo() {
        return to;
    }

    int getAmount() {
        return amount;
    }
}
