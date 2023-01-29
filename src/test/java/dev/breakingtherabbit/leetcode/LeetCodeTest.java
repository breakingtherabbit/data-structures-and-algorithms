package dev.breakingtherabbit.leetcode;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@TestMethodOrder(OrderAnnotation.class)
class LeetCodeTest {

    private final Solution solution = new Solution();
    private final static Integer[] sorted1 = {1, 1, 3, 5, 5, 7, 9, 9};
    private final static Integer[] expected1 = {1, 3, 5, 7, 9, 1, 5, 9};
    private final static Integer[] sorted2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    private final static Integer[] expected2 = {0, 1, 2, 3, 4, 0, 1, 1, 2, 3};
    private final static Integer[] sorted3 = {1, 1, 2};
    private final static Integer[] expected3 = {1, 2, 1};

    @ParameterizedTest
    @MethodSource("provideParameters")
    @Order(26)
    void shouldRemoveDuplicatesFromSortedArray(Integer[] sortedNumbers, Integer[] expectedNumbers, int length) {
        Integer[] actual = solution.sortUniqueElements(sortedNumbers);

        assertEquals(length, solution.numberOfUniqueElements(actual));
        assertIterableEquals(Arrays.asList(expectedNumbers), Arrays.asList(actual));
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(sorted1, expected1, 5),
                Arguments.of(sorted2, expected2, 5),
                Arguments.of(sorted3, expected3, 2)
        );
    }

}