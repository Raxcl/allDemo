package raxcl.structure.flyweight;

/**
 * 不需要共享的Flyweight子类。因为Flyweight接口共享成为可能，但它并不强制共享。
 *
 * @author D30100_chenlong
 * @date 2022/6/29 16:49
 */
public class UnsharedConcreteFlyweight extends Flyweight{
    @Override
    public void operation(int extrinsicstate) {
        System.out.println("不共享的具体Flyweight:"+ extrinsicstate);
    }
}
