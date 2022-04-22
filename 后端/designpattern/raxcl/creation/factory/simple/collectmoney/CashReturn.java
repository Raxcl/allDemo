package raxcl.creation.factory.simple.collectmoney;

/**
 * 返利收费子类
 *
 * @author D30100_chenlong
 * @date 2022/4/7 11:01
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
        if (money>=moneyCondition){
            money -= moneyReturn;
        }
        return money;
    }
}
