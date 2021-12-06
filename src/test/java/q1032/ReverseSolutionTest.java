package q1032;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReverseSolutionTest {

    @Test
    void shouldReturnCorrectResultWithLongSequenceWord() {
        ReverseStreamChecker checker = new ReverseStreamChecker(new String[]{"bbb"});
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
    }

    @Test
    void shouldReturnCorrectResponsesWithSampleTest() {
        ReverseStreamChecker checker = new ReverseStreamChecker(new String[]{"cd", "f", "kl"});
        assertFalse(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('c'));
        assertTrue(checker.query('d'));
        assertFalse(checker.query('e'));
        assertTrue(checker.query('f'));
        assertFalse(checker.query('g'));
        assertFalse(checker.query('h'));
        assertFalse(checker.query('i'));
        assertFalse(checker.query('j'));
        assertFalse(checker.query('k'));
        assertTrue(checker.query('l'));
    }

    @Test
    void shouldReturnCorrectResponsesWithCustomTest() {
        ReverseStreamChecker checker = new ReverseStreamChecker(new String[]{"cd", "de", "def"});
        assertFalse(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('c'));
        assertTrue(checker.query('d'));
        assertTrue(checker.query('e'));
        assertTrue(checker.query('f'));
        assertFalse(checker.query('g'));
        assertFalse(checker.query('h'));
        assertFalse(checker.query('i'));
        assertFalse(checker.query('j'));
        assertFalse(checker.query('k'));
        assertFalse(checker.query('l'));
    }

    @Test
    void shouldReturnResponseWithTimeExceededTestCase1() {
        ReverseStreamChecker checker = new ReverseStreamChecker(new String[]{"ab","ba","aaab","abab","baa"});
        assertFalse(checker.query('a'));
        assertFalse(checker.query('a'));
        assertFalse(checker.query('a'));
        assertFalse(checker.query('a'));
        assertFalse(checker.query('a'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('a'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('a'));
        assertTrue(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertTrue(checker.query('a'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('a'));
        assertTrue(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertTrue(checker.query('a'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('a'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('a'));
        assertTrue(checker.query('a'));
        assertFalse(checker.query('a'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('a'));
        assertTrue(checker.query('a'));
        assertFalse(checker.query('a'));
    }

    @Test
    void shouldReturnCorrectResultWithFailedCase2() {
        ReverseStreamChecker checker = new ReverseStreamChecker(new String[]{"aa","baa","baaa","aaa","bbbb"});



        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('a'));
        assertTrue(checker.query('a'));
        assertTrue(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('a'));
        assertTrue(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertTrue(checker.query('b'));
        assertFalse(checker.query('a'));
        assertTrue(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('a'));
        assertTrue(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertTrue(checker.query('b'));
        assertFalse(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('a'));
        assertTrue(checker.query('a'));
        assertTrue(checker.query('a'));
        assertTrue(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('a'));
        assertTrue(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertTrue(checker.query('b'));
        assertFalse(checker.query('a'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('b'));
        assertFalse(checker.query('a'));


    }
}
