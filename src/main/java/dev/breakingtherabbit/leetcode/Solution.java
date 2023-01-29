package dev.breakingtherabbit.leetcode;

public class Solution {

    /**
     * <b>Problem 26</b>: Remove Duplicates from Sorted Array
     *
     * @param numbers sorted numbers
     * @return array with unique numbers first and repeat numbers last
     * @author Isaac Medeiros
     * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array">LeetCode 26</a>
     */
    public Integer[] sortUniqueElements(Integer[] numbers) {
        int i = 0;
        int counter = 0;

        while (i < numbers.length - 1 && counter < numbers.length) {
            counter++;
            int aux;

            if (numbers[i].equals(numbers[i + 1])) {
                aux = numbers[i + 1];

                for (int j = i; j < numbers.length - 1; j++) numbers[j] = numbers[j + 1];

                numbers[numbers.length - 1] = aux;

                continue;
            }

            i++;
        }

        return numbers;
    }

    /**
     * Auxiliar function for Problem 26 from LeetCode
     *
     * @param numbers array with unique numbers first and repeat numbers last
     * @return length of subarray with unique numbers
     */
    public int numberOfUniqueElements(Integer[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) return i + 1;
        }

        return numbers.length - 1;
    }

}
