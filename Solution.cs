
using System;

public class Solution
{
    private static readonly int ALPHABET_SIZE = 26;
    private static readonly string[] DIGIT_TO_WORD =
            {
              "zero", "one", "two", "three", "four", 
              "five", "six", "seven", "eight", "nine"
            };

    public int CountOddLetters(int input)
    {
        int[] frequency = CreateFrequency(input);

        int numberOfOddLetters = 0;
        foreach (int current in frequency)
        {
            if (IsOdd(current))
            {
                ++numberOfOddLetters;
            }
        }
        return numberOfOddLetters;
    }

    private int[] CreateFrequency(int input)
    {
        int[] frequency = new int[ALPHABET_SIZE];
        while (input > 0)
        {
            int digit = input % 10;
            for (int i = 0; i < DIGIT_TO_WORD[digit].Length; ++i)
            {
                ++frequency[DIGIT_TO_WORD[digit][i] - 'a'];
            }
            input /= 10;
        }
        return frequency;
    }

    private bool IsOdd(int value)
    {
        return value % 2 == 1;
    }
}
