package raxcl.structure.decorator.demo.review.review1;

/**
 * 具体的装饰对象，起到给Component添加职责的功能。
 * @author D30100_chenlong
 * @date 2022/6/1 16:09
 */
public class ConcreteDecoratorA extends Decorator{

    @Override
    public void operation() {
        super.operation();
        System.out.println("具体装饰对象A的操作");
    }
}
