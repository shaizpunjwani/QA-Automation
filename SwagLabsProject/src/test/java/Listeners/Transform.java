package Listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Transform implements IAnnotationTransformer {

    public static Method var;
    public static ITestAnnotation annot;

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(Retry.class);
        var=method;
        annot=iTestAnnotation;
    }
}
