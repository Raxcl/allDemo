package raxcl.behavior.memento;

/**
 * 管理者（Caretaker）类
 *
 * @author D30100_chenlong
 * @date 2022/6/27 13:53
 */
public class Caretaker {
    private Memento memento;

    //设置备忘录
    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
