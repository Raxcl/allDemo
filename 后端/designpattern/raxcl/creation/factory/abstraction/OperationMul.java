package raxcl.creation.factory.abstraction;


/**
 * 操作乘
 *
 * @author D30100_chenlong
 * @date 2022/4/6 15:04
 */
public class OperationMul extends Operation {
    @Override
    public double result() {
        return numberA*numberB;
    }
}
