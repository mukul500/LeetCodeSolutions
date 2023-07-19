package array


/**
 * Complexity
 * Time complexity:
 * I think it's O(n^2) because we have 2 nested loops
 *
 * Space complexity:
 * I think it's O(n) because we have to store the result
 */

//Problem Link https://leetcode.com/problems/3sum/description/

class `3Sum` {

    fun threeSum(nums: IntArray): List<List<Int>> {

        //First we sort the list in Ascending Order
        val sortedNum = nums.sorted()

        //We create a Mutable Set to store the result, Set doesn't allow duplicates. We get rid of the Duplicates
        val result = mutableSetOf<List<Int>>()

        //We Iterate the Array Consider the first element as the Start Number
        for (startNum in nums.indices) {

            //We will use the Two Pointer Approach to find the other two numbers
            //We will start the leftPointer from the next element of the Start Number
            var leftPointer = startNum + 1

            //We will start the rightPointer from the last element of the Array
            var rightPointer = nums.size - 1


            //We will continue the loop till the leftPointer is less than the rightPointer
            while (leftPointer < rightPointer) {

                //We will check if the sum of the three numbers is equal to 0
                if (sortedNum[leftPointer] + sortedNum[rightPointer] == -sortedNum[startNum]) {
                    //If the sum is equal to 0, we will add the three numbers to the result
                    result.add(listOf(sortedNum[startNum], sortedNum[leftPointer], sortedNum[rightPointer]))
                }

                //If the sum is less than 0, we will increment the leftPointer to get closer to the sum
                if (sortedNum[leftPointer] + sortedNum[rightPointer] + sortedNum[startNum] < 0) {
                    leftPointer++
                } else {
                    //If the sum is greater than 0, we will decrement the rightPointer to get closer to the sum
                    rightPointer--
                }
            }
        }
        //We will return the result as a List
        return result.toList()
    }
}