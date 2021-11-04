package q191;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Solution s = new Solution();
    static Random r = new Random();

    @RepeatedTest(50)
    void shouldReturnCorrectResult() {
        int i = r.nextInt();
        long expected = Integer.toBinaryString(i).chars().filter(c -> c == '1').count();

        assertThat(s.hammingWeight(i)).isEqualTo(expected);
    }
}
