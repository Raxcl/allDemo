package raxcl.structure.decorator.demo.review.review1;

/**
 * @author D30100_chenlong
 * @date 2022/6/1 16:10
 */
public class DecoratorMain {
    public static void main(String[] args) {
        ConcreteComponent component = new ConcreteComponent();
        ConcreteDecoratorA c = new ConcreteDecoratorA();
        c.setComponent(component);
        c.operation();
    }
}
