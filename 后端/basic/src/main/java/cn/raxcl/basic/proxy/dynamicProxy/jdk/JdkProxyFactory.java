package cn.raxcl.basic.proxy.dynamicProxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author D30100_chenlong
 * date 2022/7/18 21:54
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(), // 代理需要实现的接口，可指定多个
                new DynamicProxy(target) //代理对象对应的自定义 InvocationHandler
        );
    }
}
