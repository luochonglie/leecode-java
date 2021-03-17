package top.chonglie.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.w3c.dom.ls.LSException;

import static org.junit.Assert.*;


public class AddTwoNumbersTest {

    AddTwoNumbers obj = new AddTwoNumbers();

    @Test
    public void testAddTwoNumbers() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode expected = new ListNode(0);

        ListNode actual = obj.addTwoNumbers(l1, l2);


        Assert.assertEquals(String.format("%s + %s != %s", l1, l2, expected), expected, actual);

        l1 = new ListNode(new int[]{3,7,8});
        l2 = new ListNode(new int[]{1,1,1});

        expected = new ListNode(new int[]{4,8,9});

        actual = obj.addTwoNumbers(l1, l2);
        Assert.assertEquals(String.format("%s + %s != %s", l1, l2, expected), expected, actual);


    }

    @Test
    public void testBuildListNode(){
        int[] input = new int[]{3,5,4};
        ListNode result = new ListNode(input);
        Assert.assertEquals("354", result.toString());

    }

}