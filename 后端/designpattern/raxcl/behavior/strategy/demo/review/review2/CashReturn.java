package raxcl.behavior.strategy.demo.review.review2;

/**
 * @author D30100_chenlong
 * @date 2022/5/31 13:34
 */
public class CashReturn extends CashSuper{
    private double moneyCondition;
    private double moneyReturn;
    public CashReturn(double moneyCondition, double moneyReturn){
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }
    @Override
    public double acceptCash(double money) {
        if (money>=moneyCondition){
            return money-moneyReturn;
        }
        return money;
    }
}
