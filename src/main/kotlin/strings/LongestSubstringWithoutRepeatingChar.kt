package strings

class LongestSubstringWithoutRepeatingChar {

    fun lengthOfLongestSubstring(s: String): Int {

        //Set to store the repeated characters
        val charactersRepeated = mutableSetOf<Char>()

        //Start Index of maximum substring
        var startIndex = 0

        //Maximum Length of the substring
        var maxLength = 0


        //We Traverse through the string
        s.forEachIndexed { currentIndex, c ->

            //If the character is already present in the set
            if (charactersRepeated.contains(c)) {
                //We remove the characters from the set until we find the character that is repeated
                while (true) {
                    //We Remove the character from the set
                    charactersRepeated.remove(s[startIndex])
                    //We Keep Incrementing the Start Index until we find the character that is repeated
                    if (s[startIndex] == c) {
                        startIndex++
                        break
                    }
                    startIndex++
                }
                //We add the character to the set
                charactersRepeated.add(c)

            }
            //If the character is not present in the set
            else {
                //We add the character to the set
                charactersRepeated.add(c)

                //We Calculate the Current Total Length from the Start Index to the Current Index
                val currentTotalLength = (currentIndex - startIndex) + 1

                //We Update the Max Length
                maxLength = maxOf(currentTotalLength, maxLength)

            }
        }

        return maxLength
    }

}