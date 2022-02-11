package top.chonglie.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class AddTwoNumbersTest {

    AddTwoNumbers solution = new AddTwoNumbers();

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new ListNode(0), new ListNode(0), new ListNode(0))
                , Arguments.of(new ListNode(new int[]{3, 7, 8}), new ListNode(new int[]{1, 1, 1}), new ListNode(new int[]{4, 8, 9}))
                , Arguments.of(new ListNode(new int[]{9, 9, 9, 9, 9, 9, 9}), new ListNode(new int[]{9, 9, 9, 9}), new ListNode(new int[]{8, 9, 9, 9, 0, 0, 0, 1}))
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testAddTwoNumbers(ListNode l1, ListNode l2, ListNode expected) {
        Assertions.assertEquals(expected, solution.addTwoNumbers(l1, l2), String.format("%s + %s != %s", l1, l2, expected));
    }
}