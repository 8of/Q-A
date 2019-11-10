func nearestVegetarianRestaurant(totalRestaurants:Int, allLocations:[[Int]],
                                 numRestaurants:Int) -> [[Int]]
{
    let mapped:[[Int]] = allLocations.map({
        el in
        var newArray = el
        let new: Int = el.first! * el.first! + el.last! * el.last!
        newArray.append(new)
        return newArray
    })
    
    let sorted: [[Int]] = mapped.sorted(by: { left, right in return left.last! <= right.last! })
    let answer: [[Int]] = sorted.map({
        el in
        var newEl = el
        newEl.removeLast()
        return newEl
    })
    return Array(answer.prefix(numRestaurants))
}

let arr: [[Int]] = [[1, 2], [2, 3]];

print(nearestVegetarianRestaurant(totalRestaurants: 2, allLocations: arr, numRestaurants: 1))

func optimalUtilization(deviceCapacity:Int, foregroundAppList:[[Int]],
                        backgroundAppList:[[Int]]) -> [[Int]]
{
    var paired: [[Int]] = []
    for (frontIndex, frontApp) in foregroundAppList.enumerated() {
        for (backIndex, backApp) in backgroundAppList.enumerated() {
            let capacity = frontApp.last! + backApp.last!
            if (capacity <= deviceCapacity) {
                paired.append([frontIndex+1, backIndex+1, capacity])
            }
        }
    }
    let sorted = paired.sorted(by: { left, right in return left.last! > right.last! })
    if (sorted.first == nil) {
        return []
    }
    let filtered = sorted.filter({ el in return el.last! == sorted.first!.last! })
    return filtered.map({
        arr in
        return [arr[0], arr[1]]
    })
}

// let arr: [[Int]] = [[1, 2], [2, 3]];

print(optimalUtilization(deviceCapacity: 7, foregroundAppList: [[1,2],[2,4],[3,6]], backgroundAppList: [[1,2]]))

print(optimalUtilization(deviceCapacity: 10, foregroundAppList: [[1,3],[2,5],[3,7],[4,10]], backgroundAppList: [[1,2],[2,3],[3,4],[4,5]]))
