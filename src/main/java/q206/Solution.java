package q206;

/**
 * <p>206. Reverse Linked List</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/reverse-linked-list/">
 *         https://leetcode.com/problems/reverse-linked-list/
 *       </a>
 * </p>
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = newHead;
            newHead = temp;
        }

        return newHead;
    }
}