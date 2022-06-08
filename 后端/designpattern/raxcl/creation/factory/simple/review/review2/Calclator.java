package raxcl.creation.factory.simple.review.review2;


/**
 * @author D30100_chenlong
 * @date 2022/5/30 16:45
 */
public class Calclator {
    public static void main(String[] args) {
        Operation operator;
        operator = OperationFactory.createOperation('+');
        operator.numberA = 1.1;
        operator.numberB = 2.2;
        System.out.println(operator.result());
    }
}
