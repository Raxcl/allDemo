package raxcl.behavior.strategy.collectmoney;

/**
 * 封账了具体的算法或行为（具体算法A）
 *
 * @author D30100_chenlong
 * @date 2022/4/22 17:03
 */
public class ConcreteStrategyA extends Strategy{
    /**
     * 算法A实现方法
     */
    @Override
    public void algorithmInterface() {
        System.out.println("算法A实现");
    }
}
