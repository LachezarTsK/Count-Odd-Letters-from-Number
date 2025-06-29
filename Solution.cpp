
#include <array>
#include <unordered_map>
using namespace std;

class Solution {

    static const int ALPHABET_SIZE = 26;
    inline static const unordered_map<int, string> DIGIT_TO_WORD = 
               { {0, "zero"}, {1, "one"}, {2, "two"}, {3, "three"}, {4, "four"},
                 {5, "five"}, {6, "six"}, {7, "seven"}, {8, "eight"}, {9, "nine"} };

public:
    int countOddLetters(int input) const {
        array<int, ALPHABET_SIZE> frequency = createFrequency(input);

        int numberOfOddLetters = 0;
        for (int current : frequency) {
            if (isOdd(current)) {
                ++numberOfOddLetters;
            }
        }
        return numberOfOddLetters;
    }

    array<int, ALPHABET_SIZE> createFrequency(int input) const {
        array<int, ALPHABET_SIZE> frequency{};
        while (input > 0) {
            int digit = input % 10;
            for (int i = 0; i < DIGIT_TO_WORD.at(digit).length(); ++i) {
                ++frequency[DIGIT_TO_WORD.at(digit)[i] - 'a'];
            }
            input /= 10;
        }
        return frequency;
    }

    bool isOdd(int value) const {
        return value % 2 == 1;
    }
};
