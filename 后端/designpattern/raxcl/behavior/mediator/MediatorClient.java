package raxcl.behavior.mediator;

/**
 * @author D30100_chenlong
 * @date 2022/6/29 15:19
 */
public class MediatorClient {
    public static void main(String[] args) {
        ConcreteMediator m = new ConcreteMediator();

        ConcreteColleague1 c1 = new ConcreteColleague1(m);
        ConcreteColleague2 c2 = new ConcreteColleague2(m);

        //让中介者认识各个具体同事类对象
        m.setColleague1(c1);
        m.setColleague2(c2);

        //具体同事类对选哪个的发送信息都是通过中介者转发
        c1.send("吃过饭了吗？");
        c2.send("没有呢，你打算请客？");
    }
}
