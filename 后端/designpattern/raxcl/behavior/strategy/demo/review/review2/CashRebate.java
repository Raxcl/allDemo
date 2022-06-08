package raxcl.behavior.strategy.demo.review.review2;

/**
 * @author D30100_chenlong
 * @date 2022/5/31 13:35
 */
public class CashRebate extends CashSuper{
    private double moneyRebate;
    public CashRebate(double moneyRebate){
        this.moneyRebate = moneyRebate;
    }
    @Override
    public double acceptCash(double money) {
        return money*moneyRebate;
    }
}
