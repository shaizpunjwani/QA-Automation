package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before("@MobileTest")
    public void InvokeMethodBefore()
    {
        System.out.println("Mobile method running before");
    }
    @After("@MobileTest")
    public void InvokeMethodAfter()
    {
        System.out.println("Mobile method running after");
    }

    @Before("@WebTest")
    public void InvokeMethodBeforeWeb()
    {
        System.out.println("Web method running before");
    }
    @After("@WebTest")
    public void InvokeMethodAfterWeb()
    {
        System.out.println("Web method running after");
    }
}
