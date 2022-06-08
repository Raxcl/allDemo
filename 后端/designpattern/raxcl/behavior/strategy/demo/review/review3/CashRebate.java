package raxcl.behavior.strategy.demo.review.review3;

/**
 * @author D30100_chenlong
 * @date 2022/6/6 15:41
 */
public class CashRebate extends CashSuper{
    private double rebate;
    public CashRebate(double rebate){
        this.rebate = rebate;
    }
    @Override
    public double acceptCash(double money) {
        return money*rebate;
    }
}
