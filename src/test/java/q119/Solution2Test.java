package q119;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Solution2Test {

    static Solution2 s = new Solution2();

    @RepeatedTest(34)
    void shouldGetCorrectRow(RepetitionInfo info) {
        List<Integer> list = s.getRow(info.getCurrentRepetition() - 1);
        assertThat(list)
            .isNotNull()
            .hasSize(info.getCurrentRepetition());

        long val = 1;
        assertThat(list.get(0))
            .isEqualTo(val);
        for (int i = 1; i < list.size(); ++i) {
            val = val * (info.getCurrentRepetition() - i) / i;
            assertThat(list.get(i))
                .isEqualTo(val);
        }
    }
}
