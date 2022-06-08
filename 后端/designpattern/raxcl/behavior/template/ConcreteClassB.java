package raxcl.behavior.template;

/**
 * @author D30100_chenlong
 * @date 2022/6/8 13:59
 */
public class ConcreteClassB extends AbstractTemplate{
    @Override
    public void primitiveOperation1() {
        //与ConcreteClassA不同的方法实现
        System.out.println("具体类B方法1实现");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("具体类B方法2实现");
    }
}
