package q2;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution2Test {

    static Solution2 s = new Solution2();
    static Random r = new Random();
    private static final BigInteger SMALL_UPPER_LIMIT = new BigInteger("999999999999999");
    private static final BigInteger ACTUAL_UPPER_LIMIT = new BigInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");

    @Test
    void shouldReturnZeroWithZeros() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        assertThat(s.addTwoNumbers(l1, l2))
            .isNotNull()
            .extracting(n -> n.val, n -> n.next)
            .containsExactly(0, null);
    }

    @Test
    void shouldReturnZeroWithOneZeros() {
        ListNode l1 = new ListNode(0, new ListNode(1, new ListNode(1, new ListNode(1))));
        ListNode l2 = new ListNode(0);

        ListNode result = s.addTwoNumbers(l1, l2);
        assertThat(result).isNotNull();

        int expected = 1110;
        while (result != null) {
            int mod = expected % 10;
            assertThat(result.val)
                .isEqualTo(mod);
            expected = expected / 10;
            result = result.next;
        }
        //should consume all digits in expected
        assertThat(expected).isZero();
    }

    @Test
    void shouldReturnCorrectResultWithSingleNode() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);

        assertThat(s.addTwoNumbers(l1, l2))
            .isNotNull()
            .extracting(n -> n.val, n -> n.next)
            .containsExactly(2, null);
    }

    @Test
    void shouldReturnCorrectResultWithNodesNeedCarrying() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        ListNode result = s.addTwoNumbers(l1, l2);
        assertThat(result)
            .isNotNull();

        int expected = 10;
        while (result != null) {
            int mod = expected % 10;
            assertThat(result.val)
                .isEqualTo(mod);
            expected = expected / 10;
            result = result.next;
        }
        //should consume all digits in expected
        assertThat(expected).isZero();
    }

    @Test
    void shouldReturnCorrectResultWithComplexSample1() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = s.addTwoNumbers(l1, l2);
        assertThat(result)
            .isNotNull();

        int expected = 807;
        while (result != null) {
            int mod = expected % 10;
            assertThat(result.val)
                .isEqualTo(mod);
            expected = expected / 10;
            result = result.next;
        }
        //should consume all digits in expected
        assertThat(expected).isZero();
    }

    @Test
    void shouldReturnCorrectResultWithComplexSample2() {
        ListNode l1 = new ListNode(9);
        for (int i = 1; i < 7; ++i) {
            l1 = new ListNode(9, l1);
        }
        ListNode l2 = new ListNode(9);
        for (int i = 1; i < 4; ++i) {
            l2 = new ListNode(9, l2);
        }

        ListNode result = s.addTwoNumbers(l1, l2);
        assertThat(result)
            .isNotNull();

        int expected = 10009998;
        while (result != null) {
            int mod = expected % 10;
            assertThat(result.val)
                .isEqualTo(mod);
            expected = expected / 10;
            result = result.next;
        }
        //should consume all digits in expected
        assertThat(expected).isZero();
    }

    @RepeatedTest(20)
    void shouldReturnCorrectResultWithTwoSmallRandomNumbers() {
        BigInteger i1 = randomBigInt(SMALL_UPPER_LIMIT);
        ListNode l1 = null;
        BigInteger temp = i1;
        ListNode curr = null;
        while (temp.compareTo(BigInteger.ZERO) > 0) {
            BigInteger mod = temp.mod(BigInteger.TEN);
            if (curr == null) {
                l1 = curr = new ListNode(mod.intValue());
            } else {
                curr = (curr.next = new ListNode(mod.intValue()));
            }
            temp = temp.divide(BigInteger.TEN);
        }
        BigInteger i2 = randomBigInt(SMALL_UPPER_LIMIT);
        ListNode l2 = null;
        temp = i2;
        curr = null;
        while (temp.compareTo(BigInteger.ZERO) > 0) {
            BigInteger mod = temp.mod(BigInteger.TEN);
            if (curr == null) {
                l2 = curr = new ListNode(mod.intValue());
            } else {
                curr = (curr.next = new ListNode(mod.intValue()));
            }
            temp = temp.divide(BigInteger.TEN);
        }

        ListNode result = s.addTwoNumbers(l1, l2);
        assertThat(result).isNotNull();

        BigInteger expected = i1.add(i2);
        while (result != null) {
            int mod = expected.mod(BigInteger.TEN).intValue();
            assertThat(result.val).isEqualTo(mod);

            expected = expected.divide(BigInteger.TEN);
            result = result.next;
        }
        //should consume all digits in expected
        assertEquals(BigInteger.ZERO, expected);
    }

    @RepeatedTest(20)
    void shouldReturnCorrectResultWithSmallRandomNumberAndOneExtremeNumber() {
        BigInteger i1 = randomBigInt(SMALL_UPPER_LIMIT);
        ListNode l1 = null;
        BigInteger temp = i1;
        ListNode curr = null;
        while (temp.compareTo(BigInteger.ZERO) > 0) {
            BigInteger mod = temp.mod(BigInteger.TEN);
            if (curr == null) {
                l1 = curr = new ListNode(mod.intValue());
            } else {
                curr = (curr.next = new ListNode(mod.intValue()));
            }
            temp = temp.divide(BigInteger.TEN);
        }
        BigInteger i2 = randomBigInt(ACTUAL_UPPER_LIMIT);
        ListNode l2 = null;
        temp = i2;
        curr = null;
        while (temp.compareTo(BigInteger.ZERO) > 0) {
            BigInteger mod = temp.mod(BigInteger.TEN);
            if (curr == null) {
                l2 = curr = new ListNode(mod.intValue());
            } else {
                curr = (curr.next = new ListNode(mod.intValue()));
            }
            temp = temp.divide(BigInteger.TEN);
        }

        ListNode result = s.addTwoNumbers(l1, l2);
        assertThat(result).isNotNull();

        BigInteger expected = i1.add(i2);
        BigInteger tempExpected = expected;
        while (result != null) {
            int mod = tempExpected.mod(BigInteger.TEN).intValue();
            assertThat(result.val).isEqualTo(mod);

            tempExpected = tempExpected.divide(BigInteger.TEN);
            result = result.next;
        }
        //should consume all digits in expected
        assertEquals(BigInteger.ZERO, tempExpected);

        // check with l1 and l2 interchanged
        result = s.addTwoNumbers(l1, l2);
        assertThat(result).isNotNull();

        tempExpected = expected;
        while (result != null) {
            int mod = tempExpected.mod(BigInteger.TEN).intValue();
            assertThat(result.val).isEqualTo(mod);

            tempExpected = tempExpected.divide(BigInteger.TEN);
            result = result.next;
        }
        //should consume all digits in expected
        assertEquals(BigInteger.ZERO, tempExpected);
    }

    @RepeatedTest(20)
    void shouldReturnCorrectResultWithTwoExtremeRandomNumbers() {
        BigInteger i1 = randomBigInt(ACTUAL_UPPER_LIMIT);
        ListNode l1 = null;
        BigInteger temp = i1;
        ListNode curr = null;
        while (temp.compareTo(BigInteger.ZERO) > 0) {
            BigInteger mod = temp.mod(BigInteger.TEN);
            if (curr == null) {
                l1 = curr = new ListNode(mod.intValue());
            } else {
                curr = (curr.next = new ListNode(mod.intValue()));
            }
            temp = temp.divide(BigInteger.TEN);
        }
        BigInteger i2 = randomBigInt(ACTUAL_UPPER_LIMIT);
        ListNode l2 = null;
        temp = i2;
        curr = null;
        while (temp.compareTo(BigInteger.ZERO) > 0) {
            BigInteger mod = temp.mod(BigInteger.TEN);
            if (curr == null) {
                l2 = curr = new ListNode(mod.intValue());
            } else {
                curr = (curr.next = new ListNode(mod.intValue()));
            }
            temp = temp.divide(BigInteger.TEN);
        }

        ListNode result = s.addTwoNumbers(l1, l2);
        assertThat(result).isNotNull();

        BigInteger expected = i1.add(i2);
        while (result != null) {
            int mod = expected.mod(BigInteger.TEN).intValue();
            assertThat(result.val).isEqualTo(mod);

            expected = expected.divide(BigInteger.TEN);
            result = result.next;
        }
        //should consume all digits in expected
        assertEquals(BigInteger.ZERO, expected);
    }

    private BigInteger randomBigInt(BigInteger upperLimit) {
        BigInteger randomNumber;
        do {
            randomNumber = new BigInteger(upperLimit.bitLength(), r);
        } while (randomNumber.compareTo(upperLimit) >= 0);
        return randomNumber;
    }
}
