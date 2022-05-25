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
        CashContext cashContext = null;
        switch (type){
            case "正常收费": cashContext = new CashContext(new CashNormal());break;
            case "打八折" : cashContext = new CashContext(new CashRebate(0.8));break;
            case "满300减100" : cashContext = new CashContext(new CashReturn(300, 100));break;
            default : throw new RuntimeException("输入有误");
        }
        return cashContext.getResult(price*number);
    }
}
