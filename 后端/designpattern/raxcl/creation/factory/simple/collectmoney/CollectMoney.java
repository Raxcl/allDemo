package raxcl.creation.factory.simple.collectmoney;

/**
 * 收钱主类
 *
 * @author D30100_chenlong
 * @date 2022/4/7 11:21
 */
public class CollectMoney {
    public static void main(String[] args) {
        CollectMoney method = new CollectMoney();
        System.out.println(method.cashMoney(3.2, 4,"正常收费"));

    }

    public double cashMoney(double price,int number, String type){
        //用于总计
        CashContext cashContext = switch (type) {
            case "正常收费" -> new CashContext(new CashNormal());
            case "打八折" -> new CashContext(new CashRebate(0.8));
            case "满300减100" -> new CashContext(new CashReturn(300, 100));
            default -> throw new RuntimeException("输入有误");
        };
        return cashContext.getResult(price*number);
    }
}
