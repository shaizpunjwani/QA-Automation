package RetryListener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class retrytests {

    @Test
    public void test1(){
        System.out.println("in test1");
        Assert.assertTrue(false);
    }

    @Test
    public void test2(){
        System.out.println("in test2");
    }
}
