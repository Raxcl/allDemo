package raxcl.creation.factory.abstraction;

/**
 * 客户端
 * @author D30100_chenlong
 * @date 2022/6/21 9:51
 */
public class Client {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Operation operation = OperationFactory.createOperation('+');
        operation.numberA=7;
        operation.numberB=8;
        System.out.println(operation.result());

    }
}
