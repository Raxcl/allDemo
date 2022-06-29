package raxcl.behavior.observer.demo;

/**
 * 观察者抽象类
 *
 * @author D30100_chenlong
 * @date 2022/6/17 11:48
 */
public abstract class Observer {
    protected String name;
    protected Subject sub;
    public Observer(String name, Subject sub){
        this.name = name;
        this.sub = sub;
    }

    public abstract void update();
}
