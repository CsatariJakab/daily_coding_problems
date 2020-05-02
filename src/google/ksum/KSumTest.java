package google.ksum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static google.ksum.KSum.isKSum;

class KSumTest {

    @Test
    void isKSumNullTest() {
        Assertions.assertFalse(isKSum(null, null));
        Assertions.assertFalse(isKSum(null, 12));
        Assertions.assertFalse(isKSum(new Integer[]{1, 3, 51}, null));
        Assertions.assertTrue(isKSum(new Integer[]{21, null, 3}, 24));
    }

    @Test
    void isKSumEmptyArrayTest() {
        Assertions.assertFalse(isKSum(new Integer[]{}, 13));
    }

    @Test
    void isKSumSimpleTestCase() {
        Assertions.assertTrue(isKSum(new Integer[]{51, 1, 51, 25, 100}, 101));
    }

    @Test
    void isKSumSimpleTestCase2() {
        Assertions.assertFalse(isKSum(new Integer[]{1, 23, 12, 151, 124, 1}, 200));
    }

    @Test
    void isKSumNegativeTest() {
        Assertions.assertTrue(isKSum(new Integer[]{-12, -32, 13}, 1));
    }

    @Test
    void isKSumBigNumbersTest() {
        Assertions.assertFalse(
                isKSum(new Integer[]{Integer.MAX_VALUE, 1}, Integer.MIN_VALUE));
    }

    @Test
    void isKSumHugeArrayTest() {
        Integer[] hugeArray = new Integer[]{10000000};
        for(int i = 0; i < hugeArray.length; i++) {
            hugeArray[i] = i % 10;
        }
        Assertions.assertFalse(isKSum(hugeArray, 50));
    }

}