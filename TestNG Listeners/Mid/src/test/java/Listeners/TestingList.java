package Listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestngListeners.class)
public class TestingList {

    @Test
    public void test1(){
        System.out.println("in test1");
        Assert.assertTrue(false);
    }

    @Test
    public void test2(){
        System.out.println("in test2");
    }

    @Test
    public void test3(){
        throw new SkipException("skipped case");
    }
}
