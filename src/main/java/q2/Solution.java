package q2;

/**
 * <p>2. Add Two Numbers</p>
 * <p>
 *     See <a href="https://leetcode.com/problems/add-two-numbers/">
 *           https://leetcode.com/problems/add-two-numbers/
 *         </a>
 * </p>
 * <p>It is a slightly verbose solution but less memory usage according to LeetCode.</p>
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode curr = null;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;

            carry = val / 10;
            ListNode next = new ListNode(val % 10);
            if (curr == null) {
                curr = head = next;
            } else {
                curr = (curr.next = next);
            }

            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remaining = l1 == null ? l2 : l1;
        while (remaining != null) {
            int val = remaining.val + carry;

            carry = val / 10;

            ListNode next = new ListNode(val % 10);
            if (curr == null) {
                curr = head = next;
            } else {
                curr = (curr.next = next);
            }

            remaining = remaining.next;
        }
        while (carry != 0) {
            ListNode next = new ListNode(carry % 10);
            curr = (curr.next = next);
            carry = carry / 10;
        }
        return head;
    }
}