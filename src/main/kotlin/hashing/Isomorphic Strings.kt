package hashing

class `Isomorphic Strings` {
    fun isIsomorphic(s: String, t: String): Boolean {

        val sCharSequence = Array<Int>(200) { 0 }
        val tCharSequence = Array<Int>(200) { 0 }


        for (index in s.indices) {
            val sCharCode = s[index].code
            val tCharCode = t[index].code
            if (sCharSequence[sCharCode] != tCharSequence[tCharCode]) {
                return false
            }
            sCharSequence[sCharCode] = index
            tCharSequence[tCharCode] = index

        }
        return true
    }
}