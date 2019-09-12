package com._8of;

// Temp balance for calculations
class Balance implements Comparable<Balance> {
    private String person;
    private int amount;

    Balance(String person, int amount) {
        this.person = person;
        this.amount = amount;
    }

    String getPerson() {
        return person;
    }

    int getAmount() {
        return amount;
    }

    void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(Balance o) {
        return Integer.compare(amount, o.amount);
    }
}
