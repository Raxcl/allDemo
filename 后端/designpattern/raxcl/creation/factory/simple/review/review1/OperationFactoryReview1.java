package raxcl.creation.factory.simple.review.review1;


/**
 * 操作符简单工厂模式复习1
 *
 * @author D30100_chenlong
 * @date 2022/5/27 10:58
 */
public class OperationFactoryReview1 {
    public static OperationReview1 createOperation(char operator){
        OperationReview1 oper;
        switch(operator){
            case '+' : oper = new OperationAddReview1();break;
            case '-' : oper = new OperationSubReview1();break;
            case '*' : oper = new OperationMulReview1();break;
            case '/' : oper = new OperationDivReview1();break;
            default : throw new RuntimeException("输入有误");
        }
        return oper;
    }
}
