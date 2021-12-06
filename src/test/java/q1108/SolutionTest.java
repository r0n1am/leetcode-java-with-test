package q1108;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Solution s = new Solution();

    @Test
    void shouldReturnCorrectString() {
        assertEquals("1[.]1[.]1[.]1", s.defangIPaddr("1.1.1.1"));
        assertEquals("255[.]100[.]50[.]0", s.defangIPaddr("255.100.50.0"));
    }
}
