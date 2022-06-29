package raxcl.behavior.mediator;

/**
 * 抽象同事类
 *
 * @author D30100_chenlong
 * @date 2022/6/29 15:01
 */
public class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator){
        //构造方法，得到中介者对象
        this.mediator = mediator;
    }
}
