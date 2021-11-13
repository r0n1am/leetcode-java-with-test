package q22;

import org.junit.jupiter.api.Test;

import static java.util.function.Function.identity;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    static Solution s = new Solution();

    @Test
    void shouldReturnOneResult() {
        assertThat(s.generateParenthesis(1))
            .hasSize(1)
            .flatExtracting(identity())
            .containsExactly("()");
    }

    @Test
    void shouldReturnTwoResult() {
        assertThat(s.generateParenthesis(2))
            .hasSize(2)
            .flatExtracting(identity())
            .containsExactlyInAnyOrder("()()", "(())");
    }

    @Test
    void shouldReturnFiveResult() {
        assertThat(s.generateParenthesis(3))
            .hasSize(5)
            .flatExtracting(identity())
            .containsExactlyInAnyOrder("((()))", "(()())", "()(())", "(())()", "()()()");
    }

    @Test
    void shouldReturnCorrectNumberOfResult() {
        int[] sizes = {14, 42, 132, 429, 1430};
        for (int i = 4; i <= 8; ++i) {
            assertThat(s.generateParenthesis(i)).hasSize(sizes[i-4]);
        }
    }
}
