package cn.raxcl.basic.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理demo
 *
 * @author D30100_chenlong
 * date 2022/7/18 21:39
 */
public class DynamicProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method" + method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        //调用方法后，我们可以添加自己的操作
        System.out.println("after method" + method.getName());
        return object;
    }
}
