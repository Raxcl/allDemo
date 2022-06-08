package raxcl.behavior.strategy.demo.review.review1;

/**
 * @author D30100_chenlong
 * @date 2022/5/30 17:01
 */
public class CashRebate extends CashSuper{
    private final double moneyRebate;
    public CashRebate(double moneyRebate){
        this.moneyRebate = moneyRebate;
    }
    @Override
    public double acceptCash(double money) {
        return money*moneyRebate;
    }
}
