package raxcl.behavior.command;

/**
 * ConcreteCommand类，讲一个接受者对象绑定于一个动作，调用接受者相应的操作，以实现excute
 *
 * @author D30100_chenlong
 * @date 2022/6/29 10:17
 */
public class ConcreteCommand extends Command{
    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void excute() {
        receiver.action();
    }
}
