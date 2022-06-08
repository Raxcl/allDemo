package raxcl.creation.factory.method;

/**
 * 工厂方法客户端
 *
 * @author D30100_chenlong
 * @date 2022/6/7 13:26
 */
public class FactoryClient {
    public static void main(String[] args) {
        IFactory operFactory = new DivFactory();
        Operation operation = operFactory.createOperation();

        operation.numberA = 3.4;
        operation.numberB = 4.5;

        System.out.println(operation.result());
    }
}
