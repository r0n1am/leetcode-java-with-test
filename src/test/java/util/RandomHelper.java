package util;

import java.util.Random;
import java.util.function.Predicate;

/**
 * A helper to generate random number with specific constraints
 */
public class RandomHelper {

    private final Random r;

    /**
     * Create {@link RandomHelper} with specific {@link Random} object.
     * @param r the {@link Random} object for generating random numbers.
     */
    public RandomHelper(Random r){
        this.r = r;
    }

    /**
     * Keep generate random number until the given {@code checkFunction} return false. Return the last generated number,
     * i.e. the random number that does not match the constraints of the {@code checkFunction}.
     * @param lowerBound the lower bound of the random number
     * @param range the range of the random number
     * @param checkFunction the predicate of the constraints. The method will keep running until generated random number
     *                      does not match the constraints of this predicate, i.e. when the predicate return {@code false}
     * @return the last generated integer that do not match the constraints specified in {@code checkFunction}
     */
    public int keepRandomIf(int lowerBound, int range, Predicate<Integer> checkFunction) {
        int n = r.nextInt(range) + lowerBound;
        while (checkFunction.test(n)) {
            n = r.nextInt(range) + lowerBound;
        }
        return n;
    }
}
