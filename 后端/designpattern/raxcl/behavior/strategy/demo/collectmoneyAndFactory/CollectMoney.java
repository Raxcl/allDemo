package raxcl.behavior.strategy.demo.collectmoneyAndFactory;


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
        CashContext cashContext = new CashContext(type);
        return cashContext.getResult(price*number);
    }
}
