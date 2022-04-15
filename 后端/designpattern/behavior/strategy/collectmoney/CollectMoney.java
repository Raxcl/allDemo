package behavior.strategy.collectmoney;

/**
 * 收钱主类
 *
 * @author D30100_chenlong
 * @date 2022/4/7 11:21
 */
public class CollectMoney {
    public static void main(String[] args) {
        CashSuper cashSuper = CashFactory.createCashAccept("打八折");
        System.out.println(cashSuper.acceptCash(400));;

    }
}
