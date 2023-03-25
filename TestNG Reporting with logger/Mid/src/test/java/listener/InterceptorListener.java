package listener;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class InterceptorListener implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        List<IMethodInstance> result = new ArrayList<IMethodInstance>();
        for (IMethodInstance method : list) {
            Test testMethod = method.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
            if (testMethod.priority() == 1 || testMethod.priority()==2) {
                result.add(method);
            }
        }
        return result;
    }
}
