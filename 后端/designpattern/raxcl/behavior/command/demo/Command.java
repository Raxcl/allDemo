package raxcl.behavior.command.demo;

/**
 * 抽象命令
 *
 * @author D30100_chenlong
 * @date 2022/6/28 18:33
 */
public abstract class Command {
    protected Barbecuer receiver;

    //抽象命令类，只需要确定‘烤肉串者’是谁
    public Command(Barbecuer receiver) {
        this.receiver = receiver;
    }

    /**
     * 执行命令
     */
    public abstract void excuteCommand();
}
