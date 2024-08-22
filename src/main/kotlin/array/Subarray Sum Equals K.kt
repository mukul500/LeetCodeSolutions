package array

class `Subarray Sum Equals K` {

    val map = mutableMapOf<Int, Int>()

    fun subarraySum(nums: IntArray, k: Int): Int {
        map[0] = 1
        var sum = 0
        var count = 0
        nums.forEach {
            sum += it
            val remainder = sum - k
            if (map.containsKey(remainder)) {
                count += map[remainder]!!
            }
            if (map.containsKey(sum)) {
                map[sum] = map[sum]!! + 1
            } else {
                map[sum] = 1
            }
        }
        return count
    }
}