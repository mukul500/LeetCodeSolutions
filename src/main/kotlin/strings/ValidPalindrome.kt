package strings

class ValidPalindrome {

    fun isPalindrome(s: String): Boolean {

        val charArray = s.toCharArray()
        val newString = StringBuilder()


        for (i in charArray.indices) {
            if (charArray[i].isLetterOrDigit()) {
              newString.append(charArray[i].toLowerCase())
            }
        }
        return newString.toString() == newString.reverse().toString()

    }
}