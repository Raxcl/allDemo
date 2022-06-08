package raxcl.behavior.strategy.demo.review.review3;

/**
 * @author D30100_chenlong
 * @date 2022/6/6 15:40
 */
public class CashNormal extends CashSuper{
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
