package q200;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    static Solution s = new Solution();
    static Random r = new Random();

    @Test
    void shouldCountIslandsForSampleCases() {

        assertThat(
            s.numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
            })
        ).isEqualTo(1);

        assertThat(
            s.numIslands(new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
            })
        ).isEqualTo(3);
    }
}
