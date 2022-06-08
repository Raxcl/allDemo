package raxcl.behavior.strategy;

/**
 * 封账了具体的算法或行为
 *
 * @author D30100_chenlong
 * @date 2022/4/22 17:03
 */
public class ConcreteStrategyC extends Strategy{
    /**
     * 算法C实现方法
     */
    @Override
    public void algorithmInterface() {
        System.out.println("算法C实现");
    }
}
