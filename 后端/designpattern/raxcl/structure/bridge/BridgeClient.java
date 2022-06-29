package raxcl.structure.bridge;

/**
 * @author D30100_chenlong
 * @date 2022/6/28 17:34
 */
public class BridgeClient {
    public static void main(String[] args) {
        Abstraction ab = new RefinedAbstraction();
        ab.setImplementor(new ConcreteImplementorA());
        ab.operation();

        ab.setImplementor(new ConcreteImplementorB());
        ab.operation();

    }
}
