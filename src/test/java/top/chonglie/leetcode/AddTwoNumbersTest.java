package top.chonglie.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class AddTwoNumbersTest {

    AddTwoNumbers obj = new AddTwoNumbers();

    @Test
    public void testAddTwoNumbers() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode expected = new ListNode(0);

        ListNode actual = obj.addTwoNumbers(l1, l2);

        Assertions.assertEquals(expected, actual, String.format("%s + %s != %s", l1, l2, expected));

        l1 = new ListNode(new int[]{3, 7, 8});
        l2 = new ListNode(new int[]{1, 1, 1});

        expected = new ListNode(new int[]{4, 8, 9});

        actual = obj.addTwoNumbers(l1, l2);
        Assertions.assertEquals( expected, actual,String.format("%s + %s != %s", l1, l2, expected));


    }

    @Test
    public void testBuildListNode() {
        int[] input = new int[]{3, 5, 4};
        ListNode result = new ListNode(input);
        Assertions.assertEquals("354", result.toString());

    }

}