package q1941;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    static Solution s = new Solution();
    static Random r = new Random();

    @Test
    void shouldReturnTrueWithEmptyString() {
        assertTrue(s.areOccurrencesEqual(""));
    }

    @Test
    void shouldReturnTrueWithOneLetterString() {
        for (int i = 0; i < 26; ++i) {
            String testString = "" + (char) ('a' + i);
            assertTrue(s.areOccurrencesEqual(testString));
        }
    }

    @Test
    void shouldReturnTrueWithsSingleLetterMaxOccurrencesString() {
        for (int i = 0; i < 26; ++i) {
            String testString = "";
            for (int j = 1; j <= 1000; ++j) {
                testString += (char) ('a' + i);
            }
            assertTrue(s.areOccurrencesEqual(testString));
        }
    }

    @Test
    void shouldReturnTrueWithAllLetterString() {
        assertTrue(s.areOccurrencesEqual(aToZStringBuilder().toString()));
    }

    private StringBuilder aToZStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            sb.append((char) ('a' + i));
        }
        return sb;
    }

    @Test
    void shouldReturnFalseWithSimpleString() {
        String testString = "aba";
        assertFalse(s.areOccurrencesEqual(testString));
    }

    @Test
    void shouldReturnTrueWithMultipleOccurrencesString() {
        String testString = "abababab";
        assertTrue(s.areOccurrencesEqual(testString));
    }

    @Test
    void shouldReturnTrueWithLetterOccurrencesString() {
        String repeatString = "a";
        StringBuilder testStringBuilder = new StringBuilder();
        testStringBuilder.ensureCapacity(1000);
        for (int i = 1; i < 26; ++i) {
            testStringBuilder.setLength(0);
            repeatString += (char)('a'+i);
            while (testStringBuilder.length() + repeatString.length() <= 1000) {
                testStringBuilder.append(repeatString);
            }

            assertTrue(s.areOccurrencesEqual(testStringBuilder.toString()));
        }
    }

    @RepeatedTest(2000)
    void shouldReturnCorrectResultWithRandomString() {
        StringBuilder testStringBuilder = new StringBuilder();
        int randomSize = 1 + r.nextInt(1000);

        StringBuilder charSet = aToZStringBuilder();
        int randomCharSetSize = 1+r.nextInt(26);
        for (int i = 26; i > randomCharSetSize; --i) {
            charSet.deleteCharAt(r.nextInt(charSet.length()));
        }

        Map<Character, Integer> occurrencesMap = new HashMap<>();
        charSet.chars().forEach(c -> occurrencesMap.put((char)c, 0));

        testStringBuilder.ensureCapacity(randomSize);
        while (testStringBuilder.length() < randomSize) {
            char c = (char) ('a' + r.nextInt(26));
            if (!occurrencesMap.containsKey(c) ) {
                continue;
            }
            occurrencesMap.merge(c, 1, Integer::sum);
            testStringBuilder.append(c);
        }

        String testString = testStringBuilder.toString();

        boolean expected = occurrencesMap.values().stream().filter(i -> i > 0).distinct().count() == 1;
        assertEquals(expected, s.areOccurrencesEqual(testString));
    }

    /**
     * added this test to cover the test {@link #shouldReturnCorrectResultWithRandomString} for the fact that
     * the random string generated will rarely contain letter with equal occurrences
     */
    @RepeatedTest(38) // 38 * 26 = 988 which less than 1000
    void shouldReturnTrueWithControlledRandomString(RepetitionInfo info) {
        StringBuilder testStringBuilder = new StringBuilder();
        int targetOccurrences = info.getCurrentRepetition();
        int targetSize = targetOccurrences * 26;
        testStringBuilder.ensureCapacity(targetSize);

        Map<Character, Integer> occurrencesMap = new HashMap<>();
        while (testStringBuilder.length() < targetSize) {
            char c = (char) ('a' + r.nextInt(26));
            if (occurrencesMap.getOrDefault(c, -1) >= targetOccurrences) {
                continue;
            }
            occurrencesMap.merge(c, 1, Integer::sum);
            testStringBuilder.append(c);
        }

        String testString = testStringBuilder.toString();

        assertTrue(s.areOccurrencesEqual(testString));
    }
}
