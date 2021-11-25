package q905;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Solution s = new Solution();

    @Test
    void shouldReturnCorrectResultWithSimpleArray() {
        assertThat(s.sortArrayByParity(new int[]{1,2}))
            .containsExactly(2, 1);
    }

    @Test
    void shouldReturnCorrectResultWithAllEvenArray() {
        assertThat(s.sortArrayByParity(new int[]{2,4,6,8,10,12}))
            .containsExactly(2,4,6,8,10,12);
    }

    @Test
    void shouldReturnCorrectResultWithAllOddArray() {
        assertThat(s.sortArrayByParity(new int[]{1,3,5,7,9,11}))
            .containsExactly(1,3,5,7,9,11);
    }

    @Test
    void shouldReturnCorrectResultWithOnlyOneEvenArray() {
        assertThat(s.sortArrayByParity(new int[]{1, 3, 5, 12, 7, 9, 11}))
            .containsExactly(12,3,5,1,7,9,11);
    }

    @Test
    void shouldReturnCorrectResultWithOnlyOneOddArray() {
        assertThat(s.sortArrayByParity(new int[]{2,4,6,11,8,10,12}))
            .containsExactly(2,4,6,12,8,10,11);
    }

    @Test
    void shouldReturnCorrectResultWithSampleArrays() {
        int[] actual = s.sortArrayByParity(new int[]{3, 1, 2, 4});
        assertThat(actual).hasSize(4);
        for (int i = 0; i < 4; ++i) {
            if (i <= 1) {
                assertThat(actual[i]).isEven();
            } else {
                assertThat(actual[i]).isOdd();
            }
        }


        assertThat(s.sortArrayByParity(new int[]{0}))
            .hasSize(1)
            .containsExactly(0);


        boolean isOdd = false;
        for (int i = 0; i < actual.length; ++i) {
            if (isOdd || actual[i] % 2 == 1) {
                isOdd = true;
            }
            if (isOdd) {
                assertThat(actual[i]).isOdd();
            } else {
                assertThat(actual[i]).isEven();
            }
        }
    }
}
