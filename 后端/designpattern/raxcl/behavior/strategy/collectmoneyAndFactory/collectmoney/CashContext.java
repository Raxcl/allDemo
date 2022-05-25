package raxcl.behavior.strategy.collectmoneyAndFactory.collectmoney;

import raxcl.creation.factory.simple.collectmoney.CashRebate;
import raxcl.creation.factory.simple.collectmoney.CashReturn;

/**
 * 上下文配置类
 * @author D30100_chenlong
 * @date 2022/5/25 16:58
 */
public class CashContext {
    //声明一个CashSuper对象，相当于策略模式类
    private CashSuper cs = null;

    //通过构造方法，传入具体的收费策略
    public CashContext(String type) {
        switch (type){
            case "正常收费":
                CashNormal = new CashNormal();
                break;
            case "打八折" :
                cs = new CashRebate(0.8);
                break;
            case "满300减100" :
                cs = new CashReturn(300, 100);
                break;
            default :
                throw new RuntimeException("输入有误");
        }
        this.cs = cs;
    }

    //根据收费策略的不同，获得计算结果（根据收费策略的不同，获得计算结果（））
    public double GetResult(double money){
        return cs.acceptCash(money);
    }
}
