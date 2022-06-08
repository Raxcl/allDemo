package raxcl.structure.decorator;

/**
 * @author D30100_chenlong
 * @date 2022/5/31 16:53
 */
public class DecoratorClient {
    /**
     * 装饰的方法是：
     * 首先用ConcreteComponent实例化对象c，
     * 然后用ConcreteDecoratorA的实例化对象d1来包装c，
     * 再用ConcreteDecoratorB的对象d2包装d1，最终执行d2的Operation()
     */
    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();
        d1.setComponent(c);
        d2.setComponent(d1);
        d2.operation();
    }
}
