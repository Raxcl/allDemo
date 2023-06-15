package cn.raxcl.basic.继承;

/**
 * @author D30100_chenlong
 * @date 2023/3/18 14:47
 */
public class Child extends Person{
    int a =2;
    @Override
    public void eat(){
        System.out.println("我吃"+a);
    }
}
