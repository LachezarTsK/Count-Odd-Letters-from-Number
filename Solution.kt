
class Solution {

    private companion object {
        const val ALPHABET_SIZE = 26
        val DIGIT_TO_WORD = arrayOf(
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
        )
    }

    fun countOddLetters(input: Int): Int {
        val frequency = createFrequency(input)

        var numberOfOddLetters = 0
        for (current in frequency) {
            if (isOdd(current)) {
                ++numberOfOddLetters
            }
        }
        return numberOfOddLetters
    }

    private fun createFrequency(input: Int): IntArray {
        var input = input
        val frequency = IntArray(ALPHABET_SIZE)
        while (input > 0) {
            val digit = input % 10
            for (i in DIGIT_TO_WORD[digit].indices) {
                ++frequency[DIGIT_TO_WORD[digit][i] - 'a']
            }
            input /= 10
        }
        return frequency
    }

    private fun isOdd(value: Int): Boolean {
        return value % 2 == 1
    }
}
