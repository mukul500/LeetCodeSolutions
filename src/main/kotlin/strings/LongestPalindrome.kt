package strings


/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 */

class LongestPalindrome {
    fun longestPalindrome(s: String): Int {

        //Create a Map to store the characters and their count
        val map = mutableMapOf<Char, Int>()


        //Iterate through the string and add the characters to the map
        for (i in s.indices) {
            //If the character is already present, increment the count
            if (map.containsKey(s[i])) {
                map[s[i]] = map[s[i]]!! + 1
            } else {
                //If the character is not present, add it to the map
                map[s[i]] = 1
            }
        }

        //Palindrome Length
        var palindromeLength = 0


        //Iterate through the map and check if the character count is even or odd
        for (char in map) {

            //If the character count is even, add it to the palindrome length
            if (char.value % 2 == 0) {
                palindromeLength += char.value
            } else {
                //If the character count is odd, add it to the palindrome length and decrement the count by 1
                palindromeLength += char.value - 1
            }
        }

        //If the palindrome length is less than the string length, increment the palindrome length by 1
        if (palindromeLength < s.length) {
            palindromeLength++
        }

        //Return the palindrome length
        return palindromeLength

    }
}