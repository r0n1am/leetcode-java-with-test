package q784;

import org.junit.jupiter.api.Test;

import static java.util.function.Function.identity;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Solution s = new Solution();

    @Test
    void shouldReturnTwoResultsForSingleCharacterString() {
        String str = "A";
        assertThat(s.letterCasePermutation(str))
            .hasSize(2)
            .extracting(identity())
            .containsExactlyInAnyOrder("A", "a");
    }

    @Test
    void shouldReturnOneResultsForAnyDigitsString() {
        String str = "0";
        assertThat(s.letterCasePermutation(str))
            .hasSize(1)
            .extracting(identity())
            .containsExactlyInAnyOrder("0");

        str = "123456";
        assertThat(s.letterCasePermutation(str))
            .hasSize(1)
            .extracting(identity())
            .containsExactlyInAnyOrder("123456");
    }

    @Test
    void shouldReturnCorrectResultsForSampleString() {
        String str = "a1B2";
        assertThat(s.letterCasePermutation(str))
            .hasSize(4)
            .extracting(identity())
            .containsExactlyInAnyOrder("a1b2","a1B2","A1b2","A1B2");

        str = "3z4";
        assertThat(s.letterCasePermutation(str))
            .hasSize(2)
            .extracting(identity())
            .containsExactlyInAnyOrder("3z4", "3Z4");
    }

    @Test
    void shouldReturnCorrectResultsForAllCharactersString() {
        String str = "aaaaaaAAAAAA";
        assertThat(s.letterCasePermutation(str))
            .hasSize(1<<12);
    }
}
