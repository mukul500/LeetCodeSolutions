package array

class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {


        //Create a Map to check if the element is already present
        val mapKey = mutableMapOf<Int, Boolean>()

        //Traverse the Array
        nums.forEach {
            //If the element is already present, return true
            if (mapKey.containsKey(it)) {
                mapKey[it] = true
                return true
            } else {
                //If the element is not present, add it to the map
                mapKey[it] = false
            }
        }
        return false
    }
}