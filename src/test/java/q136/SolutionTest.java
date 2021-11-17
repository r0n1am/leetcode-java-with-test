package q136;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import util.RandomHelper;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    static Solution s = new Solution();
    static Random r = new Random();
    static RandomHelper randomHelper = new RandomHelper(r);

    @RepeatedTest(500)
    void shouldReturnCorrectResultForRandomTarget() {
        int target = r.nextInt(60001) - 30000;
        int size = randomHelper.keepRandomIf(1, 30000, n -> n % 2 == 0);
        int[] input = new int[size];
        Arrays.fill(input, Integer.MAX_VALUE);

        input[r.nextInt(size)] = target;

        for (int i = 0; i < size / 2; ++i) {
            int num = randomHelper.keepRandomIf(-30000, 60001, n -> n == target);
            int firstPlace = randomHelper.keepRandomIf(0, size, n -> input[n] != Integer.MAX_VALUE);
            int secondPlace = randomHelper.keepRandomIf(0, size, n -> input[n] != Integer.MAX_VALUE || n == firstPlace);
            input[firstPlace] = num;
            input[secondPlace] = num;
        }

        assertThat(s.singleNumber(input)).isEqualTo(target);
    }

    @RepeatedTest(60001)
    @Disabled("Test all possible target only")
    void shouldReturnCorrectResultForAllPossibleTarget(RepetitionInfo info) {
        int target = info.getCurrentRepetition() - 30001;
        int size = randomHelper.keepRandomIf(1, 30000, n -> n % 2 == 0);
        int[] input = new int[size];
        Arrays.fill(input, Integer.MAX_VALUE);

        input[r.nextInt(size)] = target;

        for (int i = 0; i < size / 2; ++i) {
            int num = randomHelper.keepRandomIf(-30000, 60001, n -> n == target);
            int firstPlace = randomHelper.keepRandomIf(0, size, n -> input[n] != Integer.MAX_VALUE);
            int secondPlace = randomHelper.keepRandomIf(0, size, n -> input[n] != Integer.MAX_VALUE || n == firstPlace);
            input[firstPlace] = num;
            input[secondPlace] = num;
        }

        assertThat(s.singleNumber(input)).isEqualTo(target);
    }
}
