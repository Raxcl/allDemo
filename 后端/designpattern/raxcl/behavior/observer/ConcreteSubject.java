package raxcl.behavior.observer;

/**
 * ConcreteSubject类，叫做具体主题或具体通知者，将有关状态存入具体观察者对象；
 * 在具体主题的内部状态改变时，给所有登记过的观察者发出通知。具体主题角色通常用一个具体子类实现。
 *
 * @author D30100_chenlong
 * @date 2022/6/17 15:11
 */
public class ConcreteSubject extends Subject{
    private String subjectState;
    //具体被观察者状态

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
