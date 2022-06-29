package raxcl.behavior.observer.demo;

/**
 * 看NBA的同事
 *
 * @author D30100_chenlong
 * @date 2022/6/17 11:56
 */
public class NBAObserver extends Observer{
    public NBAObserver(String name, Subject sub) {
        super(name, sub);
    }

    @Override
    public void update() {
        System.out.println(sub.getAction()+","+name+" 关闭NBA直播，继续工作！");
    }
}
