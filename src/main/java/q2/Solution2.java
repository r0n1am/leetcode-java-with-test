package q2;

/**
 * <p>2. Add Two Numbers</p>
 * <p>
 *     See <a href="https://leetcode.com/problems/add-two-numbers/">
 *           https://leetcode.com/problems/add-two-numbers/
 *         </a>
 * </p>
 * <p>It is a less verbose version of {@link Solution} but more memory usage according to LeetCode. (0.2MB larger)</p>
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode curr = null;
        while (l1 != null || l2 != null) {
            int val = (l1 == null ? 0 : l1.val) + // val from l1
                      (l2 == null ? 0 : l2.val) + // val from l2
                      carry;

            ListNode next = new ListNode(val % 10);
            if (curr == null) {
                curr = head = next;
            } else {
                curr = (curr.next = next);
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            carry = val / 10;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head;
    }
}