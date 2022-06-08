package raxcl.structure.decorator;

/**
 * 具体的装饰对象，起到给Component添加职责的功能。
 * @author D30100_chenlong
 * @date 2022/5/31 16:11
 */
public class ConcreteDecoratorA extends Decorator{
    //奔雷的独有功能，以区别于ConcreteDecoratorB
    private String addedState;

    //首先运行原Component的Operation(),再执行本类的功能，如addedState,相当于对原Component进行了装饰
    @Override
    public void operation() {
        super.operation();
        addedState = "New State";
        System.out.println("具体装饰对象A的操作");
    }
}
