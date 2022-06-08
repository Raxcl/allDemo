package raxcl.behavior.strategy.demo.collectmoney;

/**
 * 上下文配置类
 * @author D30100_chenlong
 * @date 2022/5/25 16:58
 */
public class CashContext {
    //声明一个CashSuper对象，相当于策略模式类
    private CashSuper cs;

    //通过构造方法，传入具体的收费策略
    public CashContext(CashSuper cs) {
        this.cs = cs;
    }

    //根据收费策略的不同，获得计算结果（根据收费策略的不同，获得计算结果（））
    public double getResult(double money){
        return cs.acceptCash(money);
    }
}
