package array

class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {

        //Create an Result Array with all the elements as 1
        val result = IntArray(nums.size) { 1 }


        var totalSum = 1

        //Iterate the Loop and Multiply the TotalSum with the Current Element
        for (i in nums.indices) {
            //Store the TotalSum in the Result Array before the index
            result[i] = totalSum
            //Further Multiply the TotalSum with the Current Element
            totalSum *= nums[i]
        }

        totalSum = 1

        for (i in nums.size - 1 downTo 0) {
            //Multiply the TotalSum with the Current Element and Store it in the Result Array
            result[i] *= totalSum
            totalSum *= nums[i]
        }

        return result
    }
}


class ProductOfArrayExceptSelf2 {
//    fun productExceptSelf(nums: IntArray): IntArray {
//        var productArray = Array(nums.size) { 1 }
//
//        for (i in nums.indices){
//            var product = productArray[i] / nums[i]
//
//        }
//    }
}


/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
class ProductOfArrayExceptSelf3 {


    fun productExceptSelf(nums: IntArray): IntArray {
        val rightSideProduct = IntArray(nums.size) { 1 }
        val leftSideProduct = IntArray(nums.size) { 1 }
        val finalList = IntArray(nums.size) { 1 }

        for (i in nums.indices) {
            val leftProduct = leftSideProduct.getOrDefault(i - 1, 1)
            val leftNumber = nums.getOrDefault(i - 1, 1)
            leftSideProduct[i] = leftProduct * leftNumber
        }

        for (i in nums.size -1 downTo 0) {
            val rightProduct = rightSideProduct.getOrDefault(i + 1, 1)
            val rightNumber = nums.getOrDefault(i + 1, 1)
            rightSideProduct[i] = rightProduct * rightNumber
        }

        for (i in nums.indices) {
            finalList[i] =leftSideProduct[i] * rightSideProduct[i]
        }
        return finalList
    }

    private fun IntArray.getOrDefault(index: Int, defaultValue: Int): Int {
        return if (index >= 0 && index < this.size) {
            this[index]
        } else {
            defaultValue
        }
    }

}