package stack

/**


Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]

Output: 3

Explanation:

The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.
The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.



 * */

class CarFleets {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {

        var currentFleet = mutableListOf<Fleet>()

        for(index in position.indices){
            var fleet = Fleet(position[index], speed[index])
            currentFleet.add(fleet)
        }
        var totalFleets = currentFleet.size

        var isEveryCarReachedTarget = false
        while(!isEveryCarReachedTarget){

            currentFleet = moveFleets(currentFleet, target)
            isEveryCarReachedTarget =  isEveryCarReachedTarget(currentFleet, target)

        }
        return currentFleet.size


    }


    fun isEveryCarReachedTarget(fleets: List<Fleet>, target: Int): Boolean {
        for (fleet in fleets) {
            if (fleet.position < target) return false
        }
        return true
    }


    //Move the Fleet forward and if any merge is found will merge it and return the new fleet
    fun moveFleets(fleets: List<Fleet>, target: Int): MutableList<Fleet>{

        val fleetPositionMap = mutableMapOf<Int, Fleet>()
        val alreadyReachedCars = mutableListOf<Fleet>()

        for(fleet in fleets){
            if(fleet.position >= target){
                alreadyReachedCars.add(fleet)
                continue
            }
            fleet.position += fleet.minSpeed
            if(fleetPositionMap.contains(fleet.position)){
                val samePositionFleet = fleetPositionMap.get(fleet.position)
                samePositionFleet!!.minSpeed = minOf(fleet.minSpeed, samePositionFleet.minSpeed)
                fleetPositionMap[fleet.position] = samePositionFleet
            }else{
                fleetPositionMap[fleet.position] = fleet
            }
        }

        val updatedFleetList = mutableListOf<Fleet>()

        for((key, fleet) in fleetPositionMap){
            updatedFleetList.add(fleet)
        }
        updatedFleetList.addAll(alreadyReachedCars)
        return updatedFleetList


    }


    data class Fleet(
        var position: Int,
        var minSpeed: Int
    )
}