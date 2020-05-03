package google.ksum;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 *
 * Bonus: Can you do this in one pass?
 */
public class KSum {

    public static boolean isKSum(Integer[] numbers, Integer k) {
        if(numbers == null || k == null) return false;
        Set<Long> KSumPairs = new HashSet<>();
        for(Integer num : numbers) {
            if(num == null) continue;
            if(KSumPairs.contains(num.longValue())) return true;
            else KSumPairs.add(k.longValue() - num.longValue());
        }
        return false;
    }

}

