package strings

class FindAllAnagramsInAString {

    fun findAnagrams(s: String, p: String): List<Int> {


        //Target map to store the count of the characters in the target string
        val targetChar = mutableMapOf<Char, Int>()

        //Current map to store the count of the characters in the current string
        val currentChar = mutableMapOf<Char, Int>()

        //Length of the target string
        val targetStringLength = p.length

        //List to store the index of the anagrams
        val anagramIndex = mutableListOf<Int>()


        // Traverse through the target string and add the characters to the map
        p.forEach {
            if (targetChar.containsKey(it)) {
                targetChar[it] = targetChar[it]!! + 1
            } else {
                targetChar[it] = 1
            }
        }


        //Traverse through the current string
        s.forEachIndexed { index, c ->

            //Add the character to the current map
            currentChar.addChar(c)

            //If the current map size is greater than the target map size, remove the character from the map
            if (currentChar.totalChar() > targetStringLength) {

                //Remove the start index character from the map
                val removeIndex = (index - targetStringLength)
                //Remove the character from the map
                currentChar.subtractChar(s[removeIndex])
            }
            //If the current map size is equal to the target map size, check if the current map is an anagram of the target map

            if (currentChar.totalChar() == targetStringLength) {
                //If the current map is an anagram of the target map, add the start index to the list
                if (currentChar.isAnagramOf(targetChar)) {

                    //Calculate the start index
                    val startIndex = (index - targetStringLength) + 1
                    //Add the start index to the list
                    anagramIndex.add(startIndex)
                }
            }


        }

        //Return the list

        return anagramIndex.toList()

    }

    //Subtract the count of the character from the map

    fun MutableMap<Char, Int>.subtractChar(char: Char) {
        if (this.containsKey(char)) {
            val value = this[char]!!
            if (value == 1) {
                this.remove(char)
                return
            } else {
                this[char] = value - 1
            }
        } else {
            this.remove(char)
        }
    }

    //Return the total count of the characters in the map
    fun MutableMap<Char, Int>.totalChar(): Int {
        var total = 0
        this.forEach {
            total += it.value
        }
        return total
    }

    //Add the count of the character to the map
    fun MutableMap<Char, Int>.addChar(char: Char) {
        if (this.containsKey(char)) {

            this[char] = this[char]!! + 1
        } else {
            this[char] = 1
        }
    }

    //Check if the current map is an anagram of the target map
    fun Map<Char, Int>.isAnagramOf(targetChar: Map<Char, Int>): Boolean {
        targetChar.forEach {
            if (this[it.key] != it.value) {
                return false
            }
        }
        return true
    }
}