package raxcl.behavior.memento;

/**
 * 发起人（Originator）类
 *
 * @author D30100_chenlong
 * @date 2022/6/27 13:36
 */
public class Originator {
    //需要保存的属性，可能有多个
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //创建备忘录，将当前需要保存的信息导入并实例化出一个Memento对象。
    public Memento createMemento() {
        return new Memento(state);
    }

    //恢复备忘录，将Memento导入并将相关数据恢复
    public void setMemento(Memento memento){
        state = memento.getState();
    }

    //显示数据
    public void show(){
        System.out.println("state="+ state);
    }

}
