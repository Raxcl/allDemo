package raxcl.behavior.state;

/**
 * State类，抽象状态类，定义一个接口以封装与Context的一个特定状态相关的行为。
 * @author D30100_chenlong
 * @date 2022/6/21 11:32
 */
public abstract class State {
    public abstract void Handle(Context context);
}
