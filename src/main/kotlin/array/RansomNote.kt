package array

class RansomNote {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {

        val magazineChars = mutableMapOf<Char, Int>()
        val list = mutableListOf<Char>()
        list.remove('a')

        for (i in magazine.indices) {
            magazineChars.addOrIncrementChar(magazine[i])
        }

        var isRansomeNote = true
        for (i in ransomNote.indices) {
            isRansomeNote = magazineChars.isCharAvailable(ransomNote[i])
            if (!isRansomeNote) return false
        }
        return isRansomeNote
    }

    fun MutableMap<Char, Int>.isCharAvailable(char: Char): Boolean {
        if (this.containsKey(char)) {
            if (this[char]!! <= 0) {
                return false
            } else {
                this[char] = this[char]!! - 1
                return true
            }
        } else {
            return false
        }
    }

    fun MutableMap<Char, Int>.addOrIncrementChar(char: Char) {
        if (this.containsKey(char)) {
            this[char] = this[char]!! + 1
        } else {
            this[char] = 1
        }
    }
}