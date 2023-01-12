package `Design Parking System`

/**
 *
 * 解題思路
 * 這題單純將不同輸入值進行分類
 * 利用 Kotlin 的 var 加上可變性和 when 語法
 * 可以很簡單的寫出這題答案
 *
 * 網站 : https://leetcode.com/problems/design-parking-system/
 *
 * */

class ParkingSystem(var big: Int, var medium: Int, var small: Int) {
    fun addCar(carType: Int): Boolean = when (carType) {
        1 -> big-- > 0
        2 -> medium-- > 0
        3 -> small-- > 0
        else -> false
    }
}

fun main() {
    /**
     * Explanation
     * ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
     * parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
     * parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
     * parkingSystem.addCar(3); // return false because there is no available slot for a small car
     * parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.
     */
    var parkingSystem: ParkingSystem? = ParkingSystem(1, 1, 0)
    println(parkingSystem!!.addCar(1))
    println(parkingSystem!!.addCar(2))
    println(parkingSystem!!.addCar(3))
    println(parkingSystem!!.addCar(1))

}