package uber.multiplicationtree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static uber.multiplicationtree.ProductOfOthers.getProductOfOthers;

class ProductOfOthersTest {

    @Test
    void getProductOfOthersNullTest() {
        Assertions.assertEquals(null, getProductOfOthers(null));
    }

    @Test
    void getProductOfOthersEmptyArrayTest() {
        Assertions.assertTrue(Arrays.equals(new int[]{}, getProductOfOthers(new int[]{})));
    }

    @Test
    void getProductOfOthersSimpleTest() {
        Assertions.assertTrue(Arrays.equals(
                new int[]{362880, 181440, 120960, 90720, 72576, 60480, 51840, 45360, 40320},
                getProductOfOthers(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
    }

    @Test
    void getProductOfOthersSimpleTest2() {
        Assertions.assertTrue(Arrays.equals(
                new int[]{120, 60, 40, 30, 24},
                getProductOfOthers(new int[]{1, 2, 3, 4, 5})));
    }

}