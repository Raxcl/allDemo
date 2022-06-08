package raxcl.behavior.strategy.demo.review.review1;

/**
 * @author D30100_chenlong
 * @date 2022/5/30 17:03
 */
public class CashReturn extends CashSuper{
    private final double moneyCondition;
    private final double moneyReturn;

    public CashReturn(double moneyCondition, double moneyReturn){
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }
    @Override
    public double acceptCash(double money) {
        if (money >= moneyCondition){
            money -= moneyReturn;
        }
        return money;
    }
}
