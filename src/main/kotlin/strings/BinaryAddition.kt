package strings

class BinaryAddition {

    fun addBinary(a: String, b: String): String {


        var firstPointer = a.length -1
        var secondPointer = b.length -1

        var carry: Int = 0

        val stringBuilder = StringBuilder()


        while (firstPointer >= 0 || secondPointer >= 0) {

            val firstValue = a.getOrNull(firstPointer)?.digitToInt() ?: 0
            val secondValue = b.getOrNull(secondPointer)?.digitToInt() ?: 0

            var value = (carry + firstValue + secondValue) % 2
            carry = (carry + firstValue + secondValue) / 2
            stringBuilder.append(value)
            firstPointer--
            secondPointer--

        }

//        print(carry)

        if (carry == 1) {
            stringBuilder.append(1)
        }
        return stringBuilder.reverse().toString()

    }
}