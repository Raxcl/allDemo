package raxcl.creation.factory.simple.collectmoney;

/**
 * 现金简单工厂类
 *
 * @author D30100_chenlong
 * @date 2022/4/7 11:10
 */
public class CashFactory {
    public static CashSuper createCashAccept(String type){
        CashSuper cashSuper;
        switch(type){
            case "正常收费":
                cashSuper = new CashNormal();
                break;
            case "打八折":
                cashSuper = new CashRebate(0.8);
                break;
            case "满300减100":
                cashSuper = new CashReturn(300,100);
                break;
            default:
                throw new RuntimeException("输入有误");
        }
        return cashSuper;
    }
}
