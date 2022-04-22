package raxcl.creation.factory.simple.calculator;

/**
 * 操作减
 *
 * @author D30100_chenlong
 * @date 2022/4/6 15:04
 */
public class OperationSub extends Operation{
    @Override
    public double result() {
        return numberA-numberB;
    }
}
