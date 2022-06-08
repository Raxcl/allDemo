package raxcl.behavior.strategy.demo.review.review1;

/**
 * @author D30100_chenlong
 * @date 2022/5/30 17:00
 */
public class CashNormal extends CashSuper{

    @Override
    public double acceptCash(double money) {
        return money;
    }
}
