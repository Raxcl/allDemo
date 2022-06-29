package raxcl.structure.flyweight;

/**
 * 继承Flyweight超类或实现Flyweight接口，并为内部状态增加存储空间。
 *
 * @author D30100_chenlong
 * @date 2022/6/29 16:49
 */
public class ConcreteFlyweight extends Flyweight{
    @Override
    public void operation(int extrinsicstate) {
        System.out.println("具体Flyweight:"+ extrinsicstate);
    }
}
