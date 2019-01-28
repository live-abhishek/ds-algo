package leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PerfectSquaresTest {

    PerfectSquares perfectSquares;

    @Before
    public void setup(){
        perfectSquares = new PerfectSquares();
    }

    @Test
    public void test1(){
        int ans = perfectSquares.numSquares(12);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test2(){
        int ans = perfectSquares.numSquares(13);
        Assert.assertEquals(2, ans);
    }
}
