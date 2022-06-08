package raxcl.creation.factory.simple.review.review3;

/**
 * Calclator
 *
 * @author D30100_chenlong
 * @date 2022/6/1 10:18
 */
public class Calclator {
    public static void main(String[] args) {
        Operation operation = OperationFactory.createOperation('+');
        operation.numberA=1.1;
        operation.numberB=2.2;
        System.out.println(operation.result());
    }
}
