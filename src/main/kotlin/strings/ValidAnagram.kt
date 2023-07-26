package strings

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {

        //Convert the Strings to CharArray
        val input1 = s.toCharArray()
        val input2 = t.toCharArray()


        //Create a Map to store the characters and their count
        val map = mutableMapOf<Char, Int>()

        //If the size of the two strings are not equal, return false
        if (input1.size != input2.size) return false

        //Iterate through the first string and add the characters to the map
        input1.forEach {
            if (map.containsKey(it)) {
                //If the character is already present, increment the count
                map[it] = map[it]!! + 1
            } else {
                //If the character is not present, add it to the map
                map[it] = 1
            }
        }

        //Iterate through the second string and check if the character is present in the map
        var counter = 0
        input2.forEach {
            //If the character is present in the map, decrement the count and increment the counter
            if (map.containsKey(it) && map[it]!! > 0) {
                map[it] = map[it]!! - 1
                counter++
            }
        }

        //If the counter is equal to the size of the first string, return true
        return counter == input1.size
    }
}