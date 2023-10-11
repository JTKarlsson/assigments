package fi.joni.smallestgap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestGapTest {
    @Test
    public void testFindSmallestGapEdgeCases() {
        int[] numbers3 = {1};
        int result3 = SmallestGap.findSmallestGap(numbers3);
        assertEquals(0, result3);

        int[] numbers4 = {};
        int result4 = SmallestGap.findSmallestGap(numbers4);
        assertEquals(0, result4);
    }

    @Test
    public void testFindSmallestGapPositiveNumbers() {
        int[] numbers1 = {1, 5, 10};
        int result1 = SmallestGap.findSmallestGap(numbers1);
        assertEquals(3, result1);

        int[] numbers2 = {1, 10, 5};
        int result2 = SmallestGap.findSmallestGap(numbers2);
        assertEquals(3, result2);

        int[] numbers3 = {1, 4, 10, 11};
        int result3 = SmallestGap.findSmallestGap(numbers3);
        assertEquals(0, result3);

        int[] numbers4 = {10, 1, 4, 11};
        int result4 = SmallestGap.findSmallestGap(numbers4);
        assertEquals(0, result4);
    }

    @Test
    public void testFindSmallestGapLongArray() {
        int[] numbers2 = {200, 4, 10, 4, 10, 100, 4564, 2000, 345, 75, 2000, 2002, 34, 234, 4365, 234};
        int result2 = SmallestGap.findSmallestGap(numbers2);
        assertEquals(0, result2);

        int[] numbers3 = {200, 4, 10, 4, 10, 100, 2000, 345, 75, 2000, 2002, 34, 234, 4365, 234, 4564};
        int result3 = SmallestGap.findSmallestGap(numbers3);
        assertEquals(0, result3);
    }
}