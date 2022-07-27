package cn.raxcl.basic.reflect;

/**
 * @author D30100_chenlong
 * date 2022/7/19 16:55
 */
public class TargetObject {
    private String value;

    public TargetObject() {
        value = "dragon";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}
