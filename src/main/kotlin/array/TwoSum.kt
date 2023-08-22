package array

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {

        //We create a map of Int and Int
        //Where the key is the number and the value is the index

        val map = mutableMapOf<Int, Int>()

        //We traverse the array
        for (i in nums.indices) {

            //We calculate the difference between the target and the current number
            val diff = target - nums[i]

            //If the difference exists in the map, we return the indices
            if (map.containsKey(diff)) {
                //We return the indices
                return intArrayOf(map[diff]!!, i)
            }
            //If the difference doesn't exist in the map, we add the number and the index to the map
            map[nums[i]] = i
        }
        return intArrayOf()

    }

}