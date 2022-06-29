package raxcl.behavior.observer.demo;

/**
 * 观察者模式客户端
 *
 * @author D30100_chenlong
 * @date 2022/6/17 11:30
 */
public class OvserverClient {
    public static void main(String[] args) {
        //前台小姐童子喆
        Secretary tongzizhe = new Secretary();
        //看股票的同事
        StockObserver tongshi1 = new StockObserver("张三",tongzizhe);
        NBAObserver tongshi2 = new NBAObserver("李四",tongzizhe);
        //前台记下了两位同事
        tongzizhe.attach(tongshi1);
        tongzizhe.attach(tongshi2);
        //发现老板回来
        tongzizhe.setAction("老板回来了");
        tongzizhe.notifyObservers();
    }

}
