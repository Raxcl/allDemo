package raxcl.behavior.observer;

/**
 * Observer类，抽象观察者，为所有具体观察者定义一个接口，在得到主题的通知时更新自己。
 * 这个接口叫做更新接口。抽象观察者一般用一个抽象类或者一个接口实现。
 * 更新接口通常包含一个update（）方法，这个方法叫做更新方法。
 *
 * @author D30100_chenlong
 * @date 2022/6/17 14:37
 */
public interface Observer {
    void update();
}
