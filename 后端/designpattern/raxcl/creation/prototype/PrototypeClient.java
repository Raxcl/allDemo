package raxcl.creation.prototype;

import java.io.IOException;

/**
 * 原型模式客户端
 *
 * 浅拷贝和深拷贝的区别：
 * 浅拷贝：类中的属性拷贝值，类中的对象拷贝引用
 * 深拷贝；全部拷贝值
 *
 * @author D30100_chenlong
 * @date 2022/6/7 14:29
 */
public class PrototypeClient {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Prototype p = new Prototype("I");
        p.setRefObject(new RefObject("x","y"));

        System.out.println(p.getRefObject().getAddress());
        //浅拷贝，不管改变p还是p1中的对象，二者都会发生变化
        //属性都是深拷贝，对象才分深浅
        Prototype p1 = (Prototype)p.clone();
//        Prototype p1 = (Prototype)p.deepClone();
        p.getRefObject().setAddress("ax");
        p.setName("wa");
        System.out.println(p.getName());
        System.out.println(p1.getName());
        System.out.println(p.getRefObject().getAddress());
        System.out.println(p1.getRefObject().getAddress());
    }
}
