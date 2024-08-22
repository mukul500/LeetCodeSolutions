package hashing

class `Contiguous Array` {

    fun findMaxLength(nums: IntArray): Int {

        val hashMap = mutableMapOf<Int, Int>()
        var longestSubArray = 0
        var sum = 0
        nums.forEachIndexed { index, i ->
            if (i == 0) sum = sum - 1 else sum = sum + 1

            if (sum == 0) {
                if (index + 1 > longestSubArray) {
                    longestSubArray = index + 1
                }
            }
            if (hashMap.containsKey(sum)) {
                val lastIndexFound = hashMap[sum]!!
                val currentLongestLength = (index - lastIndexFound)
                if (currentLongestLength > longestSubArray) {
                    longestSubArray = currentLongestLength
                }
            } else {
                hashMap[sum] = index
            }
        }
        return longestSubArray
    }
}