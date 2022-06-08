package raxcl.behavior.strategy.demo.review.review3;


/**
 * @author D30100_chenlong
 * @date 2022/6/6 15:45
 */
public class CashContext {
    private CashSuper cs;
    public CashContext(String type){
        switch (type){
            case "正常收费": cs = new CashNormal();break;
            case "打八折" : cs = new CashRebate(0.8);break;
            case "满300减100" : cs = new CashReturn(300, 100);break;
            default : throw new RuntimeException("输入有误");
        }
    }

    public double getResult(double money){
        return cs.acceptCash(money);
    }
}
