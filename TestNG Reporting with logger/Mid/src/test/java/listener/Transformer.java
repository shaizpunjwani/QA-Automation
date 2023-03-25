package listener;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Transformer implements IAnnotationTransformer {
    public static Method var;
    public static ITestAnnotation annot;

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
//        System.out.println("method name");
//        System.out.println(method.getName());
//        if(method.getName().equals("Proceed")){
//            System.out.println("trigger");
//            updateDescription(iTestAnnotation);
//        }
        iTestAnnotation.setRetryAnalyzer(Retry.class);
        var=method;
        annot=iTestAnnotation;
    }

//    public static void updateDescription(ITestAnnotation iTestAnnotation){
//        iTestAnnotation.setEnabled(false);
//    }
}
