package raxcl.behavior.strategy.collectmoney;

/**
 * 收钱主类
 *
 * @author D30100_chenlong
 * @date 2022/4/22 17:20
 */
public class CollectMoney {
    public static void main(String[] args) {
        //由于实例化不同的策略，所以最终在调用context.ContextInterface()时，所获得的结果就不尽相同
        Context context = new Context(new ConcreteStrategyA());
        context.contextInterface();
        context = new Context(new ConcreteStrategyB());
        context.contextInterface();
        context = new Context(new ConcreteStrategyC());
        context.contextInterface();
    }
}
