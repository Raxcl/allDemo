package raxcl.behavior.state;

/**
 * @author D30100_chenlong
 * @date 2022/6/21 11:49
 */
public class ConcreteStateB extends State{
    @Override
    public void Handle(Context context) {
        context.setState(new ConcreteStateA());
    }
}
