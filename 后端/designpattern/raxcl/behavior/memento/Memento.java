package raxcl.behavior.memento;

/**
 * 备忘录（Memento）类
 *
 * @author D30100_chenlong
 * @date 2022/6/27 13:40
 */
public class Memento {
    private String state;
    //构造方法，将相关数据导入
    public Memento(String state){
        this.state = state;
    }

    //需要保存的数据属性，可以是多个
    public String getState() {
        return state;
    }
}
