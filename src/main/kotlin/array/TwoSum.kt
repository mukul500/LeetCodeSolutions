package array

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {


        //Traverse the Complete Array
        for(i in nums.indices){
            //Traverse the Array after the Index i
            for(j in i+1 until nums.size){
                //Check if the sum of the two numbers is equal to the target
                if(nums[i]+nums[j]==target){
                    return intArrayOf(i,j)
                }
            }
        }
        return intArrayOf()

    }

}