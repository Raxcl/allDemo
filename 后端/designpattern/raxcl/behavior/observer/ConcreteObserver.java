package raxcl.behavior.observer;

/**
 * ConcreteObserver类，具体观察者类，实现抽象观察者角色锁要求的更新接口，以便使本身的状态与主题的状态相协调。
 * 具体观察者角色可以保存一个指向具体主题对象的引用。具体观察者角色通常用一个具体子类实现。
 * @author D30100_chenlong
 * @date 2022/6/17 15:17
 */
public class ConcreteObserver implements Observer{
    private String name;
    private String observerState;
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject, String name){
        this.subject = subject;
        this.name = name;
    }

    @Override
    public void update() {
        observerState = subject.getSubjectState();
        System.out.println("观察者"+name+"的新状态是"+observerState);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObserverState() {
        return observerState;
    }

    public void setObserverState(String observerState) {
        this.observerState = observerState;
    }

    public ConcreteSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreteSubject subject) {
        this.subject = subject;
    }
}
