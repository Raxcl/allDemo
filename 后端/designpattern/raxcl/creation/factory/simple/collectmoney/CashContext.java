package raxcl.creation.factory.simple.collectmoney;

/**
 * 收钱上下文
 *
 * @author D30100_chenlong
 * @date 2022/4/22 17:38
 */
public class CashContext {
    private final CashSuper cashSuper;
    public CashContext(CashSuper cashSuper){
        this.cashSuper = cashSuper;
    }

    /**
     * 上下文接口，根据具体的策略方法，调用其算法方法
     */
    public double getResult(double money){
        return cashSuper.acceptCash(money);
    }
}
