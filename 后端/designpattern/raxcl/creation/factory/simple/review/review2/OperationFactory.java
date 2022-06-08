package raxcl.creation.factory.simple.review.review2;

/**
 * @author D30100_chenlong
 * @date 2022/5/30 16:40
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
