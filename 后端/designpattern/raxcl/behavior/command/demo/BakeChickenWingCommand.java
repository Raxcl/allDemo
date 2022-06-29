package raxcl.behavior.command.demo;

/**
 * 具体命令类（烤羊肉串命令）
 *
 * @author D30100_chenlong
 * @date 2022/6/28 18:49
 */
public class BakeChickenWingCommand extends Command{
    public BakeChickenWingCommand(Barbecuer receiver) {
        super(receiver);
    }

    //执行命令时，执行具体的行为
    @Override
    public void excuteCommand() {
        receiver.bakeChickenWing();
    }
}
