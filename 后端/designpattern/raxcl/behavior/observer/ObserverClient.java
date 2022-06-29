package raxcl.behavior.observer;

/**
 * 观察者客户端
 *
 * @author D30100_chenlong
 * @date 2022/6/17 15:27
 */
public class ObserverClient {
    public static void main(String[] args) {
        ConcreteSubject s = new ConcreteSubject();
        s.attach(new ConcreteObserver(s, "X"));
        s.attach(new ConcreteObserver(s, "Y"));
        s.attach(new ConcreteObserver(s, "Z"));

        s.setSubjectState("ABC");
        s.notifyObserver();
    }
}
