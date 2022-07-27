package cn.raxcl.basic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author D30100_chenlong
 * date 2022/7/19 16:59
 */
public class ReflectClient {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            ClassNotFoundException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获取 TargetObject 类的Class 对象并且创建 TargetObject 类实例
        Class<?> targetClass = Class.forName("cn.raxcl.basic.reflect.TargetObject");
        // 过时了
        // TargetObject targetObject = (TargetObject) targetClass.newInstance();
        TargetObject targetObject = (TargetObject) targetClass.getDeclaredConstructor().newInstance();

        // 获取 targetObject 类中定义的所有方法
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // 获取指定方法并调用
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject, "QAQ");

        // 获取指定参数并对参数进行修改
        Field field = targetClass.getDeclaredField("value");
        // 为了对类中的参数进行修改，我们取消安全检查
        field.setAccessible(true);
        field.set(targetObject, "cat");

        // 调用 private 方法
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        // 为了调用 private 方法我们取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}
