package raxcl.behavior.strategy.demo.review.review2;

/**
 * @author D30100_chenlong
 * @date 2022/5/31 13:35
 */
public class CashNormal extends CashSuper{
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
