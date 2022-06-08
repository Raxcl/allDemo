package raxcl.structure.decorator;

/**
 * @author D30100_chenlong
 * @date 2022/5/31 16:47
 */
public class ConcreteDecoratorB extends Decorator{

    //首先运行原Component的Operation(),再执行本类的功能，如AddedBehavior(),相当于对原Component进行了装饰
    @Override
    public void operation() {
        super.operation();
        addedBehavior();
        System.out.println("具体装饰对象B的操作");
    }

    //本类独有的方法，以区别于ConcreteDecoratorB
    private void addedBehavior() {

    }
}
