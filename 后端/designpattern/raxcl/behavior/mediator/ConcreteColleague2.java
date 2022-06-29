package raxcl.behavior.mediator;

/**
 * 同事对象
 *
 * @author D30100_chenlong
 * @date 2022/6/29 15:10
 */
public class ConcreteColleague2 extends Colleague{
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void send(String message){
        //发送信息时通常是中介者发送出去的
        mediator.send(message, this);
    }

    public void notifyColleague(String message){
        System.out.println("同事2得到信息："+ message);
    }
}
