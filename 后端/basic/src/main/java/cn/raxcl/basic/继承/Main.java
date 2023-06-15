package cn.raxcl.basic.继承;

/**
 * @author D30100_chenlong
 * @date 2023/3/18 14:47
 */
public class Main {
    public static void main(String[] args) {
        /**
         *总结：
         * 父类 = 子类
         * 方法调用的子类，属性调用父类
         * 可以将父类强转为子类，方法也会变成子类
         */
        Person person = new Child();
        person.eat(); // 我吃2
        System.out.println(person.a); // 1

        Child child = new Child();// 2
        System.out.println(child.a); // 我吃2
        child.eat();
        Child person1 = (Child) person;
        person1.eat();  // 我吃2
        System.out.println(person1.a);//2
    }
}
