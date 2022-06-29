package raxcl.behavior.state;

/**
 * 状态模式客户端
 *
 * @author D30100_chenlong
 * @date 2022/6/21 11:44
 */
public class StateClient {
    public static void main(String[] args) {
        //设置Context的初始状态为ConcreteStateA
        Context c = new Context(new ConcreteStateA());

        //不断的请求，同时更改状态
        c.request();
        c.request();
        c.request();
        c.request();
    }
}
