package array

class CombinationSum {

    private var finalCombinationSum: MutableList<List<Int>> = mutableListOf()

    fun combinationSumOld(candidates: IntArray, target: Int): List<List<Int>> {

        //Result Element
        val result = mutableListOf<List<Int>>()

        /**
         * Backtracking Function
         * @param startIndex Start Index of the Array to explore the combination from particular index
         * @param totalSum Total Sum of the current combination
         * @param currentList Current List of the combination
         */
        fun backTrack(startIndex: Int, totalSum: Int, currentList: MutableList<Int>) {


            //We check if the current sum is equal to the target
            //We make the list immutable and add it to the result
            if (totalSum == target) {
                result.add(currentList.toList())
            }

            //We start looping through the array from the startIndex
            for (i in startIndex until candidates.size) {

                //We check if the totalSum + the current element is less than or equal to the target
                val candidate = candidates[i]
                if (totalSum + candidate <= target) {
                    //we add the current element to the currentList of the Combinations
                    currentList.add(candidate)
                    //We call the backTrack function again with the current index and the totalSum + the current element
                    //To Explore the other combinations
                    backTrack(i, totalSum + candidate, currentList)
                    //We remove the last element from the currentList Means we want to Explore other combinations, So we remove the last elemeent
                    //And loop through the array again to add the element at that particular positions
                    currentList.removeAt(currentList.size - 1)
                } else {
                    return
                }
            }

        }

        candidates.sort()
        backTrack(0, 0, mutableListOf())
        return result
    }


    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        for (i in candidates.indices) {
            val list = listOf<Int>(candidates[i])
            findCombinations(
                currentTraverseArray = list,
                candidates = candidates,
                index = i,
                currentTotal = candidates[i],
                target = target
            )
        }
        return finalCombinationSum
    }

    private fun findCombinations(
        currentTraverseArray: List<Int>, candidates: IntArray, index: Int, currentTotal: Int, target: Int
    ) {
        if (index > candidates.size) return
        if (currentTotal > target) return
        if (currentTotal == target) {
            finalCombinationSum.addAll(listOf(currentTraverseArray))
        }
        for (i in index until candidates.size) {
            val newList = currentTraverseArray.toMutableList()
            newList.add(candidates[i])
            findCombinations(newList, candidates, i, currentTotal + candidates[i], target)
        }
    }
}

class CombinationSunNew {

    private val finalList: MutableList<MutableList<Int>> = mutableListOf()
    fun combinationSumOld(candidates: IntArray, target: Int): List<List<Int>> {
        for (i in candidates.indices) {
            dfs(i, mutableListOf<Int>(), candidates, target)
        }

        return finalList

    }

    fun dfs(currentIndex: Int, currentArray: MutableList<Int>, fullArray: IntArray, target: Int) {
        if (currentIndex < 0 || currentIndex > fullArray.size) return
        val currentItem = fullArray[currentIndex]
        if (target - currentItem < 0) return
        if (target - currentItem == 0) {
            currentArray.add(currentItem)
            finalList.add(currentArray)
            return
        }
        for (i in currentIndex until fullArray.size) {
            val deepCopy = currentArray.toMutableList()
            deepCopy.add(currentItem)
            dfs(currentIndex = i, currentArray = deepCopy, fullArray = fullArray, target = target - currentItem)
        }
    }

}