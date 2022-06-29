package raxcl.creation.factory.abstraction;

import java.util.HashMap;
import java.util.Map;

/**
 * 利用反射改造简单工厂模式，去掉分支判断的逻辑
 *
 * @author D30100_chenlong
 * @date 2022/4/6 15:09
 */
public class OperationFactory {
    private static Map<Character, Class<?>> allOperationMaps = new HashMap<>();

    public static void fillMap(){
        allOperationMaps.put('+', OperationAdd.class);
        allOperationMaps.put('-', OperationSub.class);
        allOperationMaps.put('*', OperationMul.class);
        allOperationMaps.put('/', OperationDiv.class);
    }

    public static Operation createOperation(char operator) throws InstantiationException, IllegalAccessException {
        Operation oper;
        fillMap();
        Class<?> operationClass = allOperationMaps.get(operator);
        if (operationClass == null){
            throw new RuntimeException("unsupported operation");
        }
        oper = (Operation) operationClass.newInstance();
        return oper;
    }
}
