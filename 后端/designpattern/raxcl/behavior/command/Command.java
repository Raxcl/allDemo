package raxcl.behavior.command;

/**
 * 抽象命令
 *
 * @author D30100_chenlong
 * @date 2022/6/28 18:33
 */
public abstract class Command {
    protected Receiver receiver;

    //抽象命令类
    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 执行命令
     */
    public abstract void excute();
}
