package strings


/*
Given two strings s and t of lengths m and n respectively, return the minimum window
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 */
class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {


        //We create a map to store the characters and their count of the target string
        val targetChars = mutableMapOf<Char, Int>()

        //We add the characters to the map
        for (char in t.toCharArray()) {
            targetChars[char] = targetChars.getOrDefault(char, 0) + 1
        }

        //We create a map to store the characters and their count of the current string
        val currentChars = mutableMapOf<Char, Int>()

        //We create a variable to store the start index of the substring
        var startIndex = 0

        //We create a variable to store the end index of the substring
        var endIndex = Int.MIN_VALUE

        //We create a variable to store the result
        var result = ""


        //We iterate through the string
        for (i in s.indices) {

            //Add the character to the current map
            currentChars.addChar(s[i])

            //If the current map contains all the characters of the target map
            if (currentChars.containsAllTargetChars(targetChars)) {
                //We Update the end index
                endIndex = i

                //We remove the characters from the start index until the current map does not contain all the characters of the target map
                while (currentChars.containsAllTargetChars(targetChars)) {
                    currentChars.removeChar(s[startIndex])
                    startIndex++
                }

                //If the result is empty or the length of the result is greater than the current substring, we update the result
                if (result == "" || result.length > endIndex - startIndex + 2)
                    result = s.substring(startIndex - 1, endIndex + 1)

            }

        }
        //We return the result
        return result

    }


    //This function is used to add the character to the map
    fun MutableMap<Char, Int>.addChar(char: Char) {
        this[char] = this.getOrDefault(char, 0) + 1
    }

    //This function is used to remove the character from the map

    fun MutableMap<Char, Int>.removeChar(char: Char) {
        this[char] = this.getOrDefault(char, 0) - 1
    }

    //TODO Optimize the Solution for compare
    //This function is used to check if the current map contains all the characters of the target map
    fun MutableMap<Char, Int>.containsAllTargetChars(
        targetChars: MutableMap<Char, Int>
    ): Boolean {
        for (char in targetChars) {
            if (char.value > this.getOrDefault(char.key, 0)) return false
        }
        return true
    }
}