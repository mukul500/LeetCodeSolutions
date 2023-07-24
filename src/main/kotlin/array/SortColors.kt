package array

class SortColors {
    fun sortColors(nums: IntArray): Unit {


        //We create a map of colors and their count
        val colors = mutableMapOf<Int, Int>()

        //We traverse the array and store the count of each color in the map
        nums.forEach {
            //If the Key already exists, we increment the count
            if (colors.containsKey(it)) {
                colors[it] = colors[it]!! + 1
            }
            //If the Key doesn't exist, we add the key and set the count to 1
            else {
                colors[it] = 1
            }
        }

        //We Create a counter to keep track of the index
        var counter = 0

        //We traverse the map and store the colors in the array
        for (i in 0 until 3) {

            //If the color exists in the map, we store the color in the array
            if (colors.containsKey(i)) {
                for (j in 0 until colors.get(i)!!) {
                    nums[counter] = i
                    counter++
                }
            }
        }
    }
}