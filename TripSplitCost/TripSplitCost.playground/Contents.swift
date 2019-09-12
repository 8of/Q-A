import Cocoa

// Few friends go on a tour.
// The travel and other expenses are  paid by some of the friends.
// So the problem is to design a program to equally divide the expenses among them and thus display as output who owes money to whom.
// Input: First line consists of the comma separated list of name of the friends. Next lines contain the money spent by each friend during the voyage.
// Output: Output should contain the list of transactions required among the friends so that the total expense is uniformly distributed among them.
// Example:- Sample Input: A,B,C,D A 300 Snacks C 100 Tickets D 200 Taxi Sample Output: B -> A 150 C -> D 50
// (Long coding problem) [Class and other OOP concepts expected in code]

struct Transaction: Hashable {
  let from: String
  let to: String
  let amount: Int

  func asString() -> String {
    return "\(from) -> \(to) \(amount)"
  }

  func hash(into hasher: inout Hasher) {
    hasher.combine(from)
  }
}

struct Balance {
  let person: String
  var amount: Int
}

final class CostSplitter {
  func getInvoices(people: [String], costs: [Transaction]) -> [String] {

    // Dictionary with people as keys and zeroes as values
    var totalCosts = people
      .reduce(
        [String: Int](),
        { dictionary, person in
          var dictionary = dictionary
          dictionary[person] = 0
          return dictionary
        }
      )

    // Fill dictionary with spent money
    var totalCost = 0
    for transaction in costs {
      totalCosts[transaction.from] = (totalCosts[transaction.from] ?? 0) + transaction.amount
      totalCost = totalCost + transaction.amount
    }

    let eachPersonExpectedToPay = totalCost / people.count

    // Subtract expected median payment
    // in order to find overpayers and underpayers
    for (person, cost) in totalCosts {
      totalCosts[person] = cost - eachPersonExpectedToPay
    }

    var overpaid = totalCosts
      .filter({ key, value in
        return value > 0
      })
      .reduce(
        [Balance](),
        { result, costs in
          let (person, amount) = costs
          var result = result
          result.append(Balance(person: person, amount: amount))
          return result
        }
      )
      .sorted(by: { $0.amount > $1.amount })

    // Also swap negative to positive for later use
    let payedTooLittle = totalCosts
      .filter({ key, value in
        return value < 0
      })
      .reduce(
        [Balance](),
        { result, costs in
          let (person, amount) = costs
          var result = result
          result.append(Balance(person: person, amount: -amount))
          return result
        }
      )
      .sorted(by: { $0.amount > $1.amount })

    var transactions = [Transaction]()

    for balancePayFrom in payedTooLittle {
      var leftToPay = balancePayFrom.amount
      for (index, balancePayTo) in overpaid.enumerated() {
        if (balancePayTo.amount == 0) {
          continue
        }
        let payNow = (balancePayFrom.amount <= balancePayTo.amount)
          ? balancePayFrom.amount
          : balancePayTo.amount
        leftToPay = leftToPay - payNow
        transactions.append(Transaction(from: balancePayFrom.person, to: balancePayTo.person, amount: payNow))
        let newBalance = Balance(person: balancePayTo.person, amount: balancePayTo.amount - payNow)
        overpaid[index] = newBalance
        if (leftToPay == 0) {
          break
        }
      }
    }

    return transactions
      .map({ $0.asString() })
  }
}

let people = ["A", "B", "C", "D"]
let costs: [Transaction] = [
  Transaction(from: "A", to: "Snacks", amount: 300),
  Transaction(from: "C", to: "Tickets", amount: 100),
  Transaction(from: "D", to: "Taxi", amount: 200)
]

let answer = CostSplitter().getInvoices(people: people, costs: costs)
print(answer)

// A - +150
// B - -150
// C - -50
// D - +50
//
// ["B -> D 50", "B -> A 150"]
