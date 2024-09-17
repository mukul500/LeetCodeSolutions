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