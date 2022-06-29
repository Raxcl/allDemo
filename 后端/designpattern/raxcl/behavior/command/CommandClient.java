package raxcl.behavior.command;

/**
 * 客户端代码，创建一个具体命令对象并设定它的接收者。
 * @author D30100_chenlong
 * @date 2022/6/28 18:55
 */
public class CommandClient {
    public static void main(String[] args) {
        Receiver r = new Receiver();
        Command c = new ConcreteCommand(r);
        Invoker i = new Invoker();

        i.setComponent(c);
        i.excuteCommand();
    }
}
