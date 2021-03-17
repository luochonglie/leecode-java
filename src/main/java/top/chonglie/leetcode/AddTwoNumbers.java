package top.chonglie.leetcode;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1) || Objects.isNull(l2)) {
            return null;
        }

        List<Integer> total = new ArrayList<>();

        int jin = 0;
        int r = 0;
        while (l1 != null || l2 != null) {
            r = 0;
            if (l1 != null && l2 != null) {
                r = l1.val + l2.val + jin;
            } else if (l1 != null) {
                r = l1.val + jin;
            } else {
                r = l2.val + jin;
            }

            if (r > 9) {
                r -= 10;
                jin = 1;
            } else {
                jin = 0;
            }
            total.add(r);


            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (jin != 0) {
            total.add(1);
        }

        ListNode end = new ListNode(total.get(total.size() - 1));
        ListNode begin = end;

        for (int i = total.size() - 2; i >= 0; i--) {
            begin = new ListNode(total.get(i), end);
            end = begin;
        }

        return begin;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int[] val) {
        if (!Objects.isNull(val) && val.length > 0) {
            ListNode end = new ListNode(val[val.length - 1]);
            ListNode begin = null;
            int i = val.length - 2;
            for (; i > 0; i--) {
                begin = new ListNode(val[i], end);
                end = begin;
            }
            if(i ==0){
                this.val = val[0];
                this.next = begin;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode)) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && (Objects.equals(next, listNode.next));
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        return String.valueOf(val) + (next == null ? "" : next.toString());
    }
}