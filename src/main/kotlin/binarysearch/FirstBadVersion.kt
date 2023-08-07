package binarysearch


abstract class VersionControl {

    private var versions = intArrayOf(0, 0, 0, 0, 1, 1)

    fun isBadVersion(index: Int): Boolean {
        return versions[index] != 0
    }

    abstract fun firstBadVersion(n: Int): Int


}

class FirstBadVersion : VersionControl() {
    override fun firstBadVersion(n: Int): Int {

        //We start with the Left Pointer at 0 and the Right Pointer at n
        var leftPointer = 0
        var rightPointer = n


        //We Assume that the Last bad version is n
        var badVersion = n


        //We iterate until the left pointer is less than or equal to the right pointer
        while (rightPointer >= leftPointer) {

            //We calculate the middle pointer
            //We don't use the formula (leftPointer + rightPointer) / 2 to avoid integer overflow
            val middle = leftPointer + (rightPointer - leftPointer) / 2

            //If the middle version is a bad version, we update the right pointer and the bad version
            if (isBadVersion(middle)) {
                rightPointer = middle -1
                badVersion = middle
            } else {

                //If the middle version is not a bad version, we update the left pointer
                leftPointer = middle + 1
            }
        }


        //We return the bad version
        return badVersion
    }

}