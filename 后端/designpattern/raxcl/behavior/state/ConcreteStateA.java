package raxcl.behavior.state;

/**
 * ConcreteState类，具体状态，每一个子类实现一个与Context的一个状态相关的行为。
 *
 * @author D30100_chenlong
 * @date 2022/6/21 11:46
 */
public class ConcreteStateA extends State{

    //设置ConcreteStateA的下一状态是ConcreteStateB
    @Override
    public void Handle(Context context) {
        context.setState(new ConcreteStateB());
    }
}
