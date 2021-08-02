package top.chonglie.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 两数相加
 * <p>给你两个 <b>非空</b> 的链表，表示两个非负的整数。它们每位数字都是按照 <b>逆序</b> 的方式存储的，并且每个节点只能存储 <b>一位</b> 数字。</p>
 * <p>请你将两个数相加，并以相同形式返回一个表示和的链表。</p>
 * <p>你可以假设除了数字 0 之外，这两个数都不会以 0 开头。</p>
 * <p></p>
 *
 * <p>
 * 示例 1：
 * <blockquote>
 * <pre>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <image src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg"></image>
 * </pre>
 * </blockquote>
 * </p>
 *
 * <p>
 * 提示：
 * <blockquote>
 * <pre>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * </pre>
 * </blockquote>
 * </p>
 *
 * @see <a href="https://leetcode-cn.com/problems/add-two-numbers/">两数相加</a>
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1) || Objects.isNull(l2)) {
            return null;
        }

        List<Integer> total = new ArrayList<>();

        int jin = 0;
        int r;
        while (l1 != null || l2 != null) {
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
        return val + (next == null ? "" : next.toString());
    }
}