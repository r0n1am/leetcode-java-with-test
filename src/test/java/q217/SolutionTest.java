package q217;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    static Solution s = new Solution();
    static Random r = new Random();

    @Test
    void shouldReturnFalseWithSingleElement() {
        int[] a = new int[1];
        assertFalse(s.containsDuplicate(a));
    }

    @Test
    void shouldReturnTrueWithSimpleDuplicate() {
        int[] a = new int[2];
        assertTrue(s.containsDuplicate(a));
    }

    @Test
    void shouldReturnFalseWithSimpleArray() {
        int[] a = new int[2];
        a[0] = 1;
        assertFalse(s.containsDuplicate(a));
    }

    @Test
    void shouldReturnCorrectResultWithMaxArray() {
        int[] a = new int[100000]; // upper bound

        for (int i = 0; i < a.length; ++i) {
            a[i] = i;
        }

        assertFalse(s.containsDuplicate(a));

        a[99999] = 0;

        assertTrue(s.containsDuplicate(a));
    }

    @RepeatedTest(50)
    void shouldReturnCorrectResultWithRandomArray() {
        int[] a = new int[1 + r.nextInt(100000)];

        for (int i = 0; i < a.length; ++i) {
            a[i] = -1000000000 + r.nextInt(2000000001);
        }

        boolean expected = Arrays.stream(a).distinct().count() != a.length; //this could be the solution itself
        assertEquals(expected, s.containsDuplicate(a));
        System.out.println(expected);
    }
}
