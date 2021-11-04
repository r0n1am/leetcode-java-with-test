package q21;

class ListNodes {
    ListNode expected;
    private ListNode expectedTail;
    ListNode left;
    private ListNode leftTail;
    ListNode right;
    private ListNode rightTail;

    void cloneToExpected(ListNode node) {
        ListNode newNode = new ListNode(node.val);
        if (expected == null) { //first element
            expected = newNode;
        } else {
            expectedTail.next = newNode;
        }
        expectedTail = newNode;
    }

    void addToLeftAndExpected(ListNode node) {
        cloneToExpected(node);
        if (left == null) { //first element
            left = node;
        } else {
            leftTail.next = node;
        }
        leftTail = node;
    }

    void addToRightAndExpected(ListNode node) {
        cloneToExpected(node);
        if (right == null) { //first element
            right = node;
        } else {
            rightTail.next = node;
        }
        rightTail = node;
    }
}