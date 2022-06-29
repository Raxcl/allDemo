package raxcl.behavior.memento.demo;

/**
 * 角色状态管理者
 *
 * @author D30100_chenlong
 * @date 2022/6/27 14:18
 */
public class RoleStateCaretaker {
    private RoleStateMemento memento;

    public RoleStateMemento getMemento() {
        return memento;
    }

    public void setMemento(RoleStateMemento memento) {
        this.memento = memento;
    }
}
