//:# Vivy iOS pre-challenge
//: This is quick assesment, please provide solution for each task. Some tasks require only a presentation on how it should work and does not need to be functional since Playground has limited capabilities.
//:
//: ----
//:
//:### 1. Parse JSON string into `Person` object and print the result
import Foundation

let jsonString = """
{
  "person": {
    "name":"John",
    "age":30,
    "car":null
  }
}
"""

struct Person {
  let name: String
  let age: Int
  let car: String?
}

// Your solution here:

extension Person: Codable {}

struct PersonWrapper {
    let person: Person
}

extension PersonWrapper: Codable {}

let jsonData = Data(jsonString.utf8)
let decoder = JSONDecoder()
do {
    let person = try decoder.decode(PersonWrapper.self, from: jsonData).person
    print(person)
} catch {
    print(error.localizedDescription)
}

//:
//: ----
//:
//:### 2. Demonstrate in code on how you would store the provided OAuth refresh token on the device
//:
let refreshToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJtYXJrbyt4czEtMTAuMkB2aXZ5LmNvbSIsInN0eXBlIjoiVVNFUiIsInNjb3BlIjpbImJhc2ljIl0sImF0aSI6ImMyOTZhNmI5LTA5ZTEtNDM5My1hNjUyLTdlYTAxMzgxMzg3NCIsImlkIjoiZGFhMjBiNWUtNGZiMS00Y2Y0LWIyMzgtZWE1NjBiZmNjN2JkIiwiZXhwIjoxNTY0NjY3MjE1LCJqdGkiOiIzZTc1NTMwNy01NTMzLTQxODctYmY2Yi1lM2E0ZDlkYWEyN2EiLCJjbGllbnRfaWQiOiJpcGhvbmUifQ.nHppGw0Q6QmYY6hgGk7ghosHx9IrpcD6qHh_VOhuZXQ"

// Your solution here:

protocol AuthKeyStorage {
    func store(key: String) -> Bool
    func key() -> String?
}

final class KeychainWrapper {
    private let tag = "com.company.appname.keys.mykey".data(using: .utf8)!
}

// MARK: - AuthKeyStorage

extension KeychainWrapper: AuthKeyStorage {

    @discardableResult func store(key: String) -> Bool {
        let addquery: [String: Any] = [kSecClass as String: kSecClassKey,
                                       kSecAttrApplicationTag as String: tag,
                                       kSecValueRef as String: key]

        let status = SecItemAdd(addquery as CFDictionary, nil)
        guard status == errSecSuccess else { return false }
        return true
    }

    func key() -> String? {
        let query: [String: Any] = [kSecClass as String: kSecClassKey,
                                    kSecAttrApplicationTag as String: tag,
                                    kSecAttrKeyType as String: kSecAttrKeyTypeRSA,
                                    kSecReturnRef as String: true]

        var item: CFTypeRef?
        let status = SecItemCopyMatching(query as CFDictionary, &item)
        guard status == errSecSuccess else { return nil }
        return item as? String
    }

}

let keychain = KeychainWrapper()
keychain.store(key: refreshToken)

// What can be improved:
// If we need to store several keys (ex: different token for different servers),
// We can add another parameter to include it in "tag" as a last part
// The same is for getting key back

//:
//: ----
//:
//:### 3. Create a function which will take an array of `VaccinationShot` and will return only the vaccination shots taken in the last 10 years, sorted by most recent
struct VaccinationShot {
  let diseaseName: String
  let yearLastTaken: Int
}

let vaccinationShots = [
  VaccinationShot(diseaseName: "Polio", yearLastTaken: 2010),
  VaccinationShot(diseaseName: "Measles", yearLastTaken: 2015),
  VaccinationShot(diseaseName: "Mumps", yearLastTaken: 2000),
  VaccinationShot(diseaseName: "Rubella", yearLastTaken: 2000),
  VaccinationShot(diseaseName: "Tetanus", yearLastTaken: 1978),
  VaccinationShot(diseaseName: "Whooping cough", yearLastTaken: 2009),
  VaccinationShot(diseaseName: "Cholera", yearLastTaken: 1999)
]

// Your solution here:

func getLatestFiltered(vaccinations: [VaccinationShot], maxYearsBack: Int, date: Date = Date()) -> [VaccinationShot] {
    let year = Calendar.current.component(.year, from: date)
    let lastYearToInclude = year - maxYearsBack

    return vaccinationShots
        .filter({ $0.yearLastTaken >= lastYearToInclude })
        .sorted(by: { $0.yearLastTaken > $1.yearLastTaken })
}

let shots = getLatestFiltered(vaccinations: vaccinationShots, maxYearsBack: 10)

print(shots)
