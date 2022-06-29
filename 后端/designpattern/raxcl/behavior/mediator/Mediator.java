package raxcl.behavior.mediator;

/**
 * 抽象中介者类
 *
 * @author D30100_chenlong
 * @date 2022/6/29 14:59
 */
public abstract class Mediator {
    //定义一个抽象的发送消息方法，得到同事对象和发送信息
    public abstract void send(String message, Colleague colleague);
}
