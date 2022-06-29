package raxcl.behavior.observer.demo;


/**
 * 老板类
 *
 * @author D30100_chenlong
 * @date 2022/6/17 13:22
 */
public class Boss implements Subject {

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.update();
        }
    }

    @Override
    public void setAction(String action) {
        actions.add(action);
    }

    @Override
    public String getAction() {
        return actions.get(0);
    }
}
