import array.SpiralMatrix
import strings.*

fun main(args: Array<String>) {

    val solution = SpiralMatrix()
    val matrix = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12)
    )

    val matrix2 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    println(solution.spiralOrder(matrix))
    println(solution.spiralOrder(matrix2))
}