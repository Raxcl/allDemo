package raxcl.structure.flyweight;

/**
 * @author D30100_chenlong
 * @date 2022/6/29 17:17
 */
public class FlyweightClient {
    public static void main(String[] args) {
        //代码外部状态
        int extrinsicstate = 22;
        FlyweightFactory f = new FlyweightFactory();

        Flyweight fx = f.getFlyweight("X");
        fx.operation(--extrinsicstate);

        Flyweight fy = f.getFlyweight("Y");
        fy.operation(--extrinsicstate);

        Flyweight fz = f.getFlyweight("Z");
        fz.operation(--extrinsicstate);

        UnsharedConcreteFlyweight uf = new UnsharedConcreteFlyweight();
        uf.operation(--extrinsicstate);

    }
}
