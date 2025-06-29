
public class Solution {

    private static final int ALPHABET_SIZE = 26;
    private static final String[] DIGIT_TO_WORD = 
        {"zero", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine"};

    public int countOddLetters(int input) {
        int[] frequency = createFrequency(input);

        int numberOfOddLetters = 0;
        for (int current : frequency) {
            if (isOdd(current)) {
                ++numberOfOddLetters;
            }
        }
        return numberOfOddLetters;
    }

    private int[] createFrequency(int input) {
        int[] frequency = new int[ALPHABET_SIZE];
        while (input > 0) {
            int digit = input % 10;
            for (int i = 0; i < DIGIT_TO_WORD[digit].length(); ++i) {
                ++frequency[DIGIT_TO_WORD[digit].charAt(i) - 'a'];
            }
            input /= 10;
        }
        return frequency;
    }

    private boolean isOdd(int value) {
        return value % 2 == 1;
    }
}
