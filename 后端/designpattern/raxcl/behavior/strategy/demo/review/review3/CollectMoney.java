package raxcl.behavior.strategy.demo.review.review3;



/**
 * @author D30100_chenlong
 * @date 2022-06-06 15:47:23
 */
public class CollectMoney {
    public static void main(String[] args) {
        CollectMoney method = new CollectMoney();
        System.out.println(method.cashMoney(3.2, 4,"正常收费"));
        System.out.println(method.cashMoney(3.2, 4,"打八折"));
        System.out.println(method.cashMoney(300, 4,"满300减100"));
    }

    public double cashMoney(double price,int number, String type){
        //用于总计
        CashContext cashContext = new CashContext(type);
        return cashContext.getResult(price*number);
    }
}
