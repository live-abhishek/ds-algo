package leetcode;

import ds.fenwickTree.FenwickTreeHelper;
import org.junit.Before;
import org.junit.Test;

public class FenwickTreeHelperTest {
    FenwickTreeHelper helper;

    @Before
    public void beforeAnyTest(){
        helper = new FenwickTreeHelper(16);
    }

    @Test
    public void rangeTest1(){
        helper.showUpdateIndexes(1);
    }
    @Test
    public void rangeTest2(){
        helper.showUpdateIndexes(2);
    }
    @Test
    public void rangeTest3(){
        helper.showUpdateIndexes(4);
    }
    @Test
    public void rangeTest4(){
        helper.showUpdateIndexes(6);
    }
    @Test
    public void rangeTest5(){
        helper.showUpdateIndexes(7);
    }
    @Test
    public void rangeTest6(){
        helper.showUpdateIndexes(8);
    }
    @Test
    public void rangeTest7(){
        helper.showUpdateIndexes(11);
    }
}
