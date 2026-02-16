package utils

fun Array<IntArray>.isValidIndex(row: Int, col: Int): Boolean {
    return row in this.indices && col in this[row].indices
}