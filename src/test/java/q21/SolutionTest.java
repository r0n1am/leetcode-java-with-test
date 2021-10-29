package q21;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class SolutionTest {

    static Solution s = new Solution();
    static Random random = new Random();

    @Test
    void shouldDirectReturnWhenOtherListIsEmpty() {
        ListNode nonNullList = new ListNode(1, null);
        assertEquals(s.mergeTwoLists(null, nonNullList), nonNullList);
        assertEquals(s.mergeTwoLists(nonNullList, null), nonNullList);
    }

    @Test
    void shouldMergeSimpleList() {
        ListNode left = new ListNode(1, null);
        ListNode right = new ListNode(2, null);
        ListNode result = s.mergeTwoLists(left, right);
        assertEquals(left, result);

        int count = 0;
        int previousVal = -1;
        while (result != null) {
            count++;
            assertThat(result.val)
                .isGreaterThanOrEqualTo(previousVal);
            previousVal = result.val;
            result = result.next;
        }
        assertEquals(2, count);
    }

    @RepeatedTest(value = 50, name = RepeatedTest.LONG_DISPLAY_NAME)
    void shouldMergeRandomList() {
        int size = random.nextInt(100) + 1;
        ListNodes nodes = generateList(size);
        ListNode result = s.mergeTwoLists(nodes.left, nodes.right);
        assertThat(result).isNotNull();

        int count = 0;
        ListNode expectedNode = nodes.expected;
        while (result != null) {
            count++;
            assertThat(result.val).isEqualTo(expectedNode.val);
            result = result.next;
            expectedNode = expectedNode.next;
        }
        assertEquals(size, count);
    }

    @RepeatedTest(value = 50, name = RepeatedTest.LONG_DISPLAY_NAME)
    void shouldMergeExtremeRandomList() {
        int size = random.nextInt(100000) + 1;
        ListNodes nodes = generateList(size);
        ListNode result = s.mergeTwoLists(nodes.left, nodes.right);
        assertThat(result).isNotNull();

        int count = 0;
        ListNode expectedNode = nodes.expected;
        while (result != null) {
            count++;
            assertThat(result.val).isEqualTo(expectedNode.val);
            result = result.next;
            expectedNode = expectedNode.next;
        }
        assertEquals(size, count);
    }

    private ListNodes generateList(int size) {
        ListNodes nodes = new ListNodes();
        int i = 0;
        int val = -100; //lower bound
        while (i < size) {
            int nextValSize = random.nextInt(size/200 + 4);
            for (int j = 0; j < nextValSize; ++j) {
                assignToRandomList(nodes, val);
                ++i;
                if (i>=size) {
                    break;
                }
            }
            val++;
            if (val >= 100) { // hit upper bound before full size list generate
                for (int j = 0; j < size-i; ++j) {
                    assignToRandomList(nodes, val);
                }
                break;
            }
        }

        return nodes;
    }

    private void assignToRandomList(ListNodes nodes, int val) {
        ListNode node = new ListNode();
        node.val = val;

        boolean toLeft = random.nextBoolean();
        if (toLeft) {
            nodes.addToLeftAndExpected(node);
        } else {
            nodes.addToRightAndExpected(node);
        }
    }
}
