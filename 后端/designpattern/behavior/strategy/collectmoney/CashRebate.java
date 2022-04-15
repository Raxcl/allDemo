package behavior.strategy.collectmoney;

/**
 * 打折收费子类
 *
 * @author D30100_chenlong
 * @date 2022/4/7 10:54
 */
public class CashRebate extends CashSuper{
    private final double moneyRebate ;
    public CashRebate(double moenyRebate){
        this.moneyRebate = moenyRebate;
    }
    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }
}
