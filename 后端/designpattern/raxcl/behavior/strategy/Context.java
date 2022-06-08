package raxcl.behavior.strategy;

/**
 * context,用一个ConcreteStrategy来配置，维护一个对Strategy对象的引用。
 * 上下文
 * @author D30100_chenlong
 * @date 2022/4/22 17:13
 */
public class Context {
    private final Strategy strategy;
    public Context(Strategy strategy){
        //初始化时，传入具体的策略对象
        this.strategy = strategy;
    }

    /**
     * 上下文接口，根据具体的策略方法，调用其算法的方法
     */
    public void contextInterface(){
        strategy.algorithmInterface();
    }
}
