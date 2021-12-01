package q206;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Solution s = new Solution();

    @Test
    void shouldReturnNullForNull() {
        assertThat(s.reverseList(null)).isNull();
    }

    @Test
    void shouldReturnUnchangeForSingleNode() {
        ListNode result = s.reverseList(new ListNode(1));
        assertThat(result)
            .isNotNull()
            .extracting("val", "next")
            .containsExactly(1, null);
    }

    @Test
    void shouldReturnReversedListForSimpleList() {
        ListNode result = s.reverseList(new ListNode(1, new ListNode(2)));
        assertThat(result)
            .isNotNull();

        int count = 0;
        while (result != null) {
            assertThat(result.val).isEqualTo(2 - count);
            count++;
            result = result.next;
        }
        assertEquals(2, count);
    }

    @Test
    void shouldReturnReversedListForSampleList() {
        ListNode result = s.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        assertThat(result)
            .isNotNull();

        int count = 0;
        while (result != null) {
            assertThat(result.val).isEqualTo(5 - count);
            count++;
            result = result.next;
        }
        assertEquals(5, count);
    }
}
