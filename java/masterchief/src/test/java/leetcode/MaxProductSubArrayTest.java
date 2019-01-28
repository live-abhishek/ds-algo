package leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxProductSubArrayTest {
    MaxProductSubArray maxProductSubArray;

    @Before
    public void init() {
        maxProductSubArray = new MaxProductSubArray();
    }

    @Test
    public void test1() {
        int[] ints = {2, 3, -2, 4};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(6, ans);
    }

    @Test
    public void test2() {
        int[] ints = {-2, 0, -1};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test3() {
        int[] ints = {2};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test4() {
        int[] ints = {-2};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(-2, ans);
    }

    @Test
    public void test5() {
        int[] ints = {0};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test6() {
        int[] ints = {3, 4};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(12, ans);
    }

    @Test
    public void test7() {
        int[] ints = {-3, 4};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(4, ans);
    }

    @Test
    public void test8() {
        int[] ints = {-3, -4};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(12, ans);
    }

    @Test
    public void test9() {
        int[] ints = {0, 0};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test10() {
        int[] ints = {0, 0, 2};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test11() {
        int[] ints = {0, 0, -2};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test12() {
        int[] ints = {0, 0, 2, -3};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(2, ans);
    }

    @Test
    public void test13() {
        int[] ints = {-2, 3, -4};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(24, ans);
    }

    @Test
    public void test14() {
        int[] ints = {2,3,-2,4,-1,2};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(2*3*2*4*2, ans);
    }

    @Test
    public void test15() {
        int[] ints = {2,3,-2,4,2,-1,2};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(2*3*2*4*2*2, ans);
    }

    @Test
    public void test16() {
        int[] ints = {2,3,0,-2,4,2,-1,2};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(2*4*2*2, ans);
    }

    @Test
    public void test17() {
        int[] ints = {-2, 0, -4};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(0, ans);
    }

    @Test
    public void test18() {
        int[] ints = {3, -1, 4};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(4, ans);
    }

    @Test
    public void test19() {
        int[] ints = {-3, -1, -4};
        int ans = maxProductSubArray.maxProduct(ints);
        Assert.assertEquals(4, ans);
    }
}
