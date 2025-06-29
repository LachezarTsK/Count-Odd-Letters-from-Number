
package main
const ALPHABET_SIZE = 26

var DIGIT_TO_WORD = []string{
    "zero", "one", "two", "three", "four",
    "five", "six", "seven", "eight", "nine"}

func countOddLetters(input int) int {
    var frequency []int = createFrequency(input)

    numberOfOddLetters := 0
    for _, current := range frequency {
        if isOdd(current) {
            numberOfOddLetters++
        }
    }
    return numberOfOddLetters
}

func createFrequency(input int) []int {
    frequency := make([]int, ALPHABET_SIZE)
    for input > 0 {
        digit := input % 10
        for i := range DIGIT_TO_WORD[digit] {
            frequency[DIGIT_TO_WORD[digit][i] - 'a']++
        }
        input /= 10
    }
    return frequency
}

func isOdd(value int) bool {
    return value % 2 == 1
}
