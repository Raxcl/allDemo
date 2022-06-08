package raxcl.behavior.strategy.demo.review.review3;

/**
 * @author D30100_chenlong
 * @date 2022/6/6 15:42
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
        return moneyCondition<=money?money-moneyReturn:money;
    }
}
