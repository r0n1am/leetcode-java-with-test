package q1287;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Solution s = new Solution();

    @Test
    void shouldReturnCorrectResultWithSampleTests() {
        int[] input = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        assertEquals(6, s.findSpecialInteger(input));

        input = new int[]{1,2,2,2,2,2,2,2,2,2,2,6,6,6,6,7,10};
        assertEquals(2, s.findSpecialInteger(input));

        input = new int[]{1,1};
        assertEquals(1, s.findSpecialInteger(input));
    }
}
