package q21;

/**
 * 21. Merge Two Sorted Lists
 * See <a herf="https://leetcode.com/problems/merge-two-sorted-lists/">
 *       https://leetcode.com/problems/merge-two-sorted-lists/
 *     </a>
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode newHead = null;
        ListNode currNode = null;
        do {
            ListNode headNode = null;
            if (l1.val > l2.val) {
                headNode = l2;
                l2 = l2.next;
            } else {
                headNode = l1;
                l1 = l1.next;
            }
            if (newHead == null) {
                newHead = headNode;
                currNode = headNode;
            } else {
                currNode.next = headNode;
                currNode = headNode;
            }
        } while (l1 != null && l2 != null);

        if (l1 != null) {
            currNode.next = l1;
        }
        if (l2 != null) {
            currNode.next = l2;
        }

        return newHead;
    }
}
