package array

class SpiralMatrix {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {

        val spiralList = mutableListOf<Int>()

        //If the matrix is empty, return empty list
        if (matrix.isEmpty()) return spiralList
        val totalElementInMatrix = matrix.size * matrix[0].size


        //We create 4 pointers to keep track of the elements in the matrix
        //leftPointer -> to keep track of the left column
        var leftPointer = 0
        //topPointer -> to keep track of the top row
        var topPointer = 0

        //rightPointer -> to keep track of the end column
        var rightPointer = matrix[0].size - 1

        //bottomPointer -> to keep track of the bottom row
        var bottomPointer = matrix.size - 1


        //We traverse the matrix in a spiral order
        while (true) {


            //We traverse the top row
            for (i in leftPointer .. rightPointer) {
                spiralList.add(matrix[topPointer][i])
            }
            //We increment the top pointer
            topPointer++


            //We traverse the right column
            for (i in topPointer .. bottomPointer) {
                spiralList.add(matrix[i][rightPointer])
            }
            //We decrement the right pointer
            rightPointer--


            //If the size of the spiral list is equal to the total number of elements in the matrix, we break
            if(spiralList.size == totalElementInMatrix) break

            //We traverse the bottom row
            for(i in rightPointer downTo leftPointer){
                spiralList.add(matrix[bottomPointer][i])
            }
            //We decrement the bottom pointer
            bottomPointer--


            //We traverse the left column
            for (i in bottomPointer downTo topPointer){
                spiralList.add(matrix[i][leftPointer])
            }
            //We increment the left pointer
            leftPointer++

            //If the size of the spiral list is equal to the total number of elements in the matrix, we break
            if(spiralList.size == totalElementInMatrix) break

        }
        return spiralList
    }
}