package proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 动态代理demo
 *
 * @author D30100_chenlong
 * date 2022/7/18 21:39
 */
public class DynamicProxy implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method" + method.getName());
        Object result = method.invoke(target, args);
        //调用方法后，我们可以添加自己的操作
        System.out.println("after method" + method.getName());
        return result;
    }
}
