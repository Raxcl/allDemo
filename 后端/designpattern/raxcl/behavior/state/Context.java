package raxcl.behavior.state;

/**
 * Context类，维护一个ConcreteState子类的实例，这个实例定义当前的状态
 *
 * @author D30100_chenlong
 * @date 2022/6/21 11:34
 */
public class Context {
    private State state;
    //定义Context的初始状态
    public Context(State state){
        this.state = state;
    }

    //可读写的状态属性，用于读取当前状态和设置新状态
    public void setState(State state){
        this.state = state;
        System.out.println("当前状态："+state.getClass().getName());
    }
    public State getState(){
        return state;
    }

    //对请求做处理，并设置下一状态
    public void request(){
        state.Handle(this);
    }

}
