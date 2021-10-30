package q118;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Solution s = new Solution();

    @RepeatedTest(30)
    void shouldGenerateList(RepetitionInfo info) {
        List<List<Integer>> list = s.generate(info.getCurrentRepetition());
        assertThat(list)
            .isNotNull()
            .hasSize(info.getCurrentRepetition());

        for (int i = 0; i < info.getCurrentRepetition(); ++i) {
            List<Integer> ints = list.get(i);
            compareRow(i, ints);
        }
    }

    private void compareRow(int row, List<Integer> ints) {
        int val = 1;
        assertThat(ints.get(0))
            .isEqualTo(val);
        for (int i = 1; i < ints.size(); ++i) {
            val = val * (row - i + 1) / i;
            assertThat(ints.get(i))
                .isEqualTo(val);
        }
    }
}
