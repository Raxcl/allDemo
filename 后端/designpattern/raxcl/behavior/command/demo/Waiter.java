package raxcl.behavior.command.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 服务员类，不用管用户想要什么烤肉，反正都是命令，只管记录订单，然后通知烤肉串者执行即可
 *
 * @author D30100_chenlong
 * @date 2022/6/28 18:52
 */
public class Waiter {
    //增加存放具体命令的容器
    private List<Command> orders = new ArrayList<>();

    //设置订单
    public void setOrder(Command command){
        //在客户提出请求时，对没货的烧烤进行回绝
        if (command.toString()=="命令模式.BakeChickenWingCommand"){
            System.out.println("服务员：鸡翅没有了，请点别的烧烤。");
        }else{
            orders.add(command);
            //记录客户所点的烧烤的日志，以备算账收钱
            System.out.println("增加订单："+ command+"时间："+new Date());
        }
    }

    //取消订单
    public void cancelOrder(Command command){
        orders.remove(command);
        System.out.println("取消订单："+ command+"时间："+new Date());

    }

    //通知执行,根据用户点好的烧烤订单通知厨房制作
    public void notifyBake(){
        for (Command cmd: orders){
            cmd.excuteCommand();
        }
    }
}
