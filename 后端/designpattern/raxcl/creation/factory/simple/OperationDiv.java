package raxcl.creation.factory.simple;

/**
 * 操作除
 *
 * @author D30100_chenlong
 * @date 2022/4/6 15:04
 */
public class OperationDiv extends Operation{
    @Override
    public double result() {
        if (numberB==0){
            throw new RuntimeException("输入有误");
        }
        return numberA/numberB;
    }
}
