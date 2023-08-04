package strings

class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {


        //Store the Longest Palindrome
        var longestPalindrome = ""

        //Store the left and right index of the longest palindrome
        var longestPalindromeLeftIndex = 0
        var longestPalindromeRightIndex = 0


        //Function to update the longest palindrome index
        fun updateLongestPalindromeIndex(leftPointer: Int, rightPointer: Int) {
            //Check if the current palindrome is greater than the longest palindrome
            if ((rightPointer - leftPointer) > longestPalindromeRightIndex - longestPalindromeLeftIndex) {
                //Update the longest palindrome index
                longestPalindromeLeftIndex = leftPointer
                longestPalindromeRightIndex = rightPointer
            }
        }

        //Iterate through the string
        for (i in s.indices) {


            //Check for the odd length palindrome
            //We take the current index as the center and expand on both sides
            var leftPointer = i
            var rightPointer = i

            //We expand on both sides until the characters are equal
            while (leftPointer >= 0 && rightPointer < s.length && s[leftPointer] == s[rightPointer]) {
                //We update the longest palindrome index
                updateLongestPalindromeIndex(leftPointer, rightPointer)
                leftPointer--
                rightPointer++
            }

            //Check for the even length palindrome

            //We take the current index and the next index as the center and expand on both sides
            leftPointer = i
            rightPointer = i + 1

            //We expand on both sides until the characters are equal
            while (leftPointer >= 0 && rightPointer < s.length && s[leftPointer] == s[rightPointer]) {
                //We update the longest palindrome index
                updateLongestPalindromeIndex(leftPointer, rightPointer)
                leftPointer--
                rightPointer++
            }
        }

        //We return the longest palindrome
        longestPalindrome = s.substring(longestPalindromeLeftIndex, longestPalindromeRightIndex + 1)
        return longestPalindrome

    }

}