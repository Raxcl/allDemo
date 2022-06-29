package raxcl.behavior.observer.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 通知者接口
 *
 * @author D30100_chenlong
 * @date 2022/6/17 12:13
 */
public interface Subject {
    //同事列表
    List<Observer> observers = new ArrayList<Observer>();
    List<String> actions = new ArrayList<String>();

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
    void setAction(String action);
    String getAction();

}
