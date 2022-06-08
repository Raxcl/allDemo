package raxcl.creation.factory.simple.review.review1;

/**
 * 输入两数和运算符号，返回结果 简单工厂模式复习1
 *
 * @author D30100_chenlong
 * @date 2022/5/27 10:54
 */
public class CalclatorReview1 {
    public static void main(String[] args) {
        OperationReview1 operator;
        operator = OperationFactoryReview1.createOperation('+');
        operator.numberA = 1.1;
        operator.numberB = 2.2;
        System.out.println(operator.result());
    }
}
