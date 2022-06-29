package raxcl.behavior.observer.demo;

/**
 * 看股票同事类
 *
 * @author D30100_chenlong
 * @date 2022/6/17 11:08
 */
public class StockObserver extends Observer {
    public StockObserver(String name, Subject sub) {
        super(name, sub);
    }

    //得到前台通知，赶快采取行动
    @Override
    public void update() {
        System.out.println(sub.getAction()+","+name+" 关闭股票行情，继续工作！");
    }
}
