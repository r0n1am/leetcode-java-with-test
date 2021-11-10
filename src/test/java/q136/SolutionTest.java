package q136;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    static Solution s = new Solution();
    static Random r = new Random();

    @RepeatedTest(500)
    void shouldReturnCorrectResultForRandomTarget() {
        int target = r.nextInt(60001) - 30000;
        int size = keepRandomIf(1, 30000, n -> n % 2 == 0);
        int[] input = new int[size];
        Arrays.fill(input, Integer.MAX_VALUE);

        input[r.nextInt(size)] = target;

        for (int i = 0; i < size / 2; ++i) {
            int num = keepRandomIf(-30000, 60001, n -> n == target);
            int firstPlace = keepRandomIf(0, size, n -> input[n] != Integer.MAX_VALUE);
            int secondPlace = keepRandomIf(0, size, n -> input[n] != Integer.MAX_VALUE || n == firstPlace);
            input[firstPlace] = num;
            input[secondPlace] = num;
        }

        assertThat(s.singleNumber(input)).isEqualTo(target);
    }

    @RepeatedTest(60001)
    @Disabled("Test all possible target only")
    void shouldReturnCorrectResultForAllPossibleTarget(RepetitionInfo info) {
        int target = info.getCurrentRepetition() - 30001;
        int size = keepRandomIf(1, 30000, n -> n % 2 == 0);
        int[] input = new int[size];
        Arrays.fill(input, Integer.MAX_VALUE);

        input[r.nextInt(size)] = target;

        for (int i = 0; i < size / 2; ++i) {
            int num = keepRandomIf(-30000, 60001, n -> n == target);
            int firstPlace = keepRandomIf(0, size, n -> input[n] != Integer.MAX_VALUE);
            int secondPlace = keepRandomIf(0, size, n -> input[n] != Integer.MAX_VALUE || n == firstPlace);
            input[firstPlace] = num;
            input[secondPlace] = num;
        }

        assertThat(s.singleNumber(input)).isEqualTo(target);
    }

    private int keepRandomIf(int lowerBound, int upperBond, Predicate<Integer> checkFunction) {
        int n = r.nextInt(upperBond) + lowerBound;
        while (checkFunction.test(n)) {
            n = r.nextInt(upperBond) + lowerBound;
        }
        return n;
    }
}
