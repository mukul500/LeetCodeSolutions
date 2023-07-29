package strings

import java.lang.NumberFormatException

class StringToInteger {


    fun myAtoi(s: String): Int {

        //Function to check if the character is a digit
        fun isDigit(c: Char): Boolean {
            return c in '0'..'9'
        }


        //Function to check if the character is a negative sign
        fun isNegative(c: Char): Boolean {
            return c == '-'
        }
        //Function to check if the character is a positive sign

        fun isPositive(c: Char): Boolean {
            return c == '+'
        }


        //Boolean to check if the number is negative
        var isNegative = false

        //Boolean to check if the number is found
        var isNumberFound = false

        //Variable to store the number
        var foundNumber = ""


        //Iterate through the string
        for (i in s.indices) {


            //If the character is a space and the number is not found, continue
            if (s[i] == ' ' && !isNumberFound) {
                continue
            }

            //If the character is a negative sign and the number is not found, set the isNegative to true and isNumberFound to true and continue
            if (isNegative(s[i]) && !isNumberFound) {
                isNegative = true
                isNumberFound = true
                continue
            }

            //If the character is a positive sign and the number is not found, set the isNegative to false and isNumberFound to true and continue
            if (isPositive(s[i]) && !isNumberFound) {
                isNegative = false
                isNumberFound = true
                continue
            }

            //If the character is a digit, add it to the foundNumber and set the isNumberFound to true
            if (isDigit(s[i])) {
                foundNumber += s[i]
                isNumberFound = true
            } else {
                break
            }
        }

        return try {


            //If the number is empty, return 0
            println("Found Number: $foundNumber")
            if (foundNumber.isEmpty()) {
                0
            } else {
                //If the number is negative, add a negative sign to the number
                if (isNegative) {
                    foundNumber = "-$foundNumber"
                }
                //Convert the number to Int and return it
                foundNumber.toInt()
            }
        } catch (e: NumberFormatException) {
            //If number is out of range, return the minimum or maximum value
            if (isNegative) {
                Int.MIN_VALUE
            } else {
                Int.MAX_VALUE
            }
        }

    }

}
