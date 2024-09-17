package array

class `Find All Numbers Disappeared in an Array` {

    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val set = HashSet<Int>()
        for (i in nums.indices) {
            set.add(i + 1)
        }

        for (i in nums.indices) {
            set.remove(nums[i])
        }
        return set.toList()
    }
}