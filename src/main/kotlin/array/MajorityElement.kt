package array

class MajorityElement {
    fun majorityElement(nums: IntArray): Int {

        val majorityMap = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            if (majorityMap.containsKey(nums[i])) {
                majorityMap[nums[i]] = majorityMap[nums[i]]!! + 1
            } else {
                majorityMap[nums[i]] = 1
            }
        }

        var majorityElement = 0
        for (map in majorityMap) {
            if (map.value > nums.size / 2) {
                majorityElement = map.key
            }
        }
        return majorityElement
    }

}