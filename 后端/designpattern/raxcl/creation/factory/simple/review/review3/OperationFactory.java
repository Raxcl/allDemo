package raxcl.creation.factory.simple.review.review3;


/**
 * @author D30100_chenlong
 * @date 2022/6/1 10:15
 */
public class OperationFactory {
    public static Operation createOperation(char operator){
        Operation oper;
        switch (operator){
            case '+': oper = new OperationAdd();break;
            case '-': oper = new OperationSub();break;
            case '*': oper = new OperationMul();break;
            case '/': oper = new OperationDiv();break;
            default : throw new RuntimeException("输入有误");
        }
        return oper;
    }
}
