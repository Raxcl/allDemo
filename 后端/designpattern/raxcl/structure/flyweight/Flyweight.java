package raxcl.structure.flyweight;

/**
 * 它是所有具体享元类的超类或接口，通过这个接口，Flyweight可以接受并作用于外部状态
 *
 * @author D30100_chenlong
 * @date 2022/6/29 16:43
 */
public abstract class Flyweight {
    public abstract void operation(int extrinsicstate);
}
