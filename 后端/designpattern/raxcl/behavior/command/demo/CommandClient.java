package raxcl.behavior.command.demo;

/**
 * @author D30100_chenlong
 * @date 2022/6/28 18:55
 */
public class CommandClient {
    public static void main(String[] args) {
        //开店前的准备
        Barbecuer boy = new Barbecuer();
        Command BakeMuttonCommand1 = new BakeMuttonCommand(boy);
        Command BakeMuttonCommand2 = new BakeMuttonCommand(boy);
        Command bakeChickenWingCommand1 = new BakeChickenWingCommand(boy);
        Waiter girl = new Waiter();

        //开门营业
        girl.setOrder(BakeMuttonCommand1);
        //服务员根据用户要求，通知厨房开始制作
        girl.setOrder(BakeMuttonCommand2);
        girl.setOrder(bakeChickenWingCommand1);
        girl.notifyBake();
    }
}
