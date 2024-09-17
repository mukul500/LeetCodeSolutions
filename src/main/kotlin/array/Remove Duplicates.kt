package array

class `Remove Duplicates` {

    fun removeDuplicates(nums: IntArray): Int {
        val hashSet = LinkedHashSet<Int>()
        for (i in nums.indices) {
            hashSet.add(nums[i])
        }

        for (i in nums.indices) {
            nums[i] = hashSet.elementAtOrElse(i) { 0 }
        }
        return hashSet.size
    }
}