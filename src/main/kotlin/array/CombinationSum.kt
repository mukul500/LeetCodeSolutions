package array

class CombinationSum {

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

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
}