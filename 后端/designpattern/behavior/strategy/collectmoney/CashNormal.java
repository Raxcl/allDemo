package behavior.strategy.collectmoney;

/**
 * 正常收费子类
 *
 * @author D30100_chenlong
 * @date 2022/4/7 10:52
 */
public class CashNormal extends CashSuper{
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
