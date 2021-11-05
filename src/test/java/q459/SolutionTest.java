package q459;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    static Solution s = new Solution();

    @Test
    void shouldReturnTrueForSingleCharacterString() {
        assertFalse(s.repeatedSubstringPattern("a"));
    }

    @Test
    void shouldReturnTrueForSingleCharacterRepeatStrings() {
        StringBuilder sb = new StringBuilder("a");
        while (sb.length() >= 10000) {
            sb.append("a");
            assertTrue(s.repeatedSubstringPattern(sb.toString()));
        }
    }

    @Test
    void shouldReturnFalseForTwoCharactersNonRepeatString() {
        assertFalse(s.repeatedSubstringPattern("ab"));
    }

    @Test
    void shouldReturnFalseForTwoCharacterRepeatsStrings() {
        StringBuilder sb = new StringBuilder("ab");
        do {
            sb.append("ab");
            assertTrue(s.repeatedSubstringPattern(sb.toString()));
        } while (sb.length() >= 10000);
    }

    @Test
    void shouldReturnFalseForSimpleNonRepeatStrings() {
        assertFalse(s.repeatedSubstringPattern("aba"));
        assertFalse(s.repeatedSubstringPattern("abac"));
        assertFalse(s.repeatedSubstringPattern("abaabb"));
        assertFalse(s.repeatedSubstringPattern("abcab"));
    }
}
