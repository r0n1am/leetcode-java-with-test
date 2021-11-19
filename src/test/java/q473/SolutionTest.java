package q473;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import util.RandomHelper;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Solution s = new Solution();
    static Random r = new Random();
    static RandomHelper helper = new RandomHelper(r);

    @Test
    void shouldReturnTrueForSimpleArray() {
        assertThat(s.makesquare(new int[]{1, 1, 1, 1})).isTrue();
        assertThat(s.makesquare(new int[]{1, 1, 1, 1, 1, 1, 1, 1})).isTrue();
    }

    @Test
    void shouldReturnTrueForSampleArray1() {
        assertThat(s.makesquare(new int[]{1, 1, 2, 2, 2})).isTrue();
    }

    @Test
    void shouldReturnFalseForSampleArray2() {
        assertThat(s.makesquare(new int[]{3, 3, 3, 3, 4})).isFalse();
    }

    @RepeatedTest(50)
    void shouldReturnFalseForRandomArray() {
        int[] input = new int[r.nextInt(15) + 1];

        int temp = 0;
        for (int i = 0; i < input.length - 1; ++i) {
            int val = r.nextInt(100_000_000) + 1;
            temp += (input[i] = val);
        }

        int count = temp;
        input[input.length - 1] = helper.keepRandomIf(1, 100_000_000, n -> (n + count) % 4 == 0);

        assertThat(s.makesquare(input)).isFalse();
    }
}
