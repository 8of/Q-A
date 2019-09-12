package com._8of;

import java.util.*;

class CostsSplitter {
    List<String> splitCosts(Collection<String> people, Collection<Transaction> costs) {
        Map<String, Integer> payments = new HashMap<>();
        // Fill Map with people
        for (String person : people) {
            payments.put(person, 0);
        }

        // Fill payed money for every person
        int totalCosts = 0;
        for (Transaction transaction : costs) {
            if (payments.containsKey(transaction.getFrom())) {
                Integer previousAmount = payments.get(transaction.getFrom());
                Integer amount = previousAmount + transaction.getAmount();
                payments.put(transaction.getFrom(), amount);
                totalCosts = totalCosts + transaction.getAmount();
            }
        }

        // Filter who paid too much or too little to two different buckets
        // It's an int and not float because divides without remainder
        // Use float / double if there is a condition when median can be not int
        int medianPayment = totalCosts / people.size();
        List<Balance> payedTooMuch = new ArrayList<>();
        List<Balance> payedTooLittle = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : payments.entrySet()) {
            String person = entry.getKey();
            Integer payment = entry.getValue();
            int newPayment = payment - medianPayment;
            int paymentForStoring = newPayment > 0 ? newPayment : -newPayment;
            Balance balance = new Balance(person, paymentForStoring);
            if (newPayment > 0) {
                payedTooMuch.add(balance);
            } else {
                payedTooLittle.add(balance);
            }
        }

        // Sort from biggest to smallest for less transactions in the answer
        payedTooMuch.sort(Collections.reverseOrder());
        payedTooLittle.sort(Collections.reverseOrder());

        // Make transactions
        // Use plain String instead of Transaction
        // Because it says so in the task
        List<String> transactions = new ArrayList<>();

        for (Balance balanceFrom : payedTooLittle) {
            int personLeftToPay = balanceFrom.getAmount();
            for (Balance balanceTo : payedTooMuch) {
                if (balanceTo.getAmount() == 0) {
                    continue;
                }
                int payToCurrentPerson = Math.min(personLeftToPay, balanceTo.getAmount());
                String transaction = balanceFrom.getPerson() + " -> " + balanceTo.getPerson() + " " + payToCurrentPerson;
                transactions.add(transaction);
                personLeftToPay = personLeftToPay - payToCurrentPerson;
                balanceTo.setAmount(balanceTo.getAmount() - payToCurrentPerson);
                if (personLeftToPay == 0) {
                    break;
                }
            }
        }
        return transactions;
    }
}
