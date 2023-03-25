package PageObjects;

import Methods.methods;

import java.awt.*;

public class Checkout extends methods {

    public void Quantity(String path, String value){
        Sendvalues(value, FindXpath(path));
    }
    public void Option(String path){
        ButtonClicking(FindXpath(path));
    }
    public void Proceed(String path){
        ButtonClicking(FindXpath(path));
    }

}
