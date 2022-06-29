package raxcl.behavior.observer.demo;


/**
 * @author D30100_chenlong
 * @date 2022/6/16 19:04
 */
public class Secretary implements Subject{

    //增加
    @Override
    public void attach(Observer observer) {
        //添加需要被帮助的同事
        observers.add(observer);
    }

    //减少
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    //通知
    //给同事们发通知：“老板来啦”
    @Override
    public void notifyObservers() {
        for (Observer o: observers){
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
