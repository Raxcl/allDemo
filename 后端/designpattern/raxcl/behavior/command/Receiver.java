package raxcl.behavior.command;

/**
 * Receiver类，知道如何实施与执行一个与请求相关的操作，任何类都可能作为一个接收者。
 *
 * @author D30100_chenlong
 * @date 2022/6/29 10:21
 */
public class Receiver {
    public void action(){
        System.out.println("执行请求！");
    }
}
