import array.SpiralMatrix
import binarysearch.BinarySearch
import binarysearch.FirstBadVersion
import binarysearch.MaximumProfitInJobScheduling
import binarysearch.SearchInRotatedSortedArray
import graphs.ZeroOneMatrix
import strings.*

fun main(args: Array<String>) {

    val solution = ZeroOneMatrix()
    print(solution.updateMatrix(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(1, 1, 1))).contentDeepToString())
}