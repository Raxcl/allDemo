package raxcl.behavior.memento;

/**
 * 备忘录客户端
 *
 * @author D30100_chenlong
 * @date 2022/6/27 13:54
 */
public class MementoClient {
    public static void main(String[] args) {
        Originator o = new Originator();
        //Originator初始状态，状态属性为"On"
        o.setState("On");
        o.show();

        Caretaker c = new Caretaker();
        //保存状态时，由于有了很好的封装，可以隐藏Originator的实现细节。
        c.setMemento(o.createMemento());

        //Originator改变了状态属性为Off
        o.setState("Off");
        o.show();

        //恢复原初始状态
        o.setMemento(c.getMemento());
        o.show();
    }
}
