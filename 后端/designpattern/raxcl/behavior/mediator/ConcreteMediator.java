package raxcl.behavior.mediator;

/**
 * 具体中介者类
 *
 * @author D30100_chenlong
 * @date 2022/6/29 15:03
 */
public class ConcreteMediator extends Mediator{
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    //需要了解所有的具体同事对象
    public void setColleague1(ConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    //重写发送信息的方法，根据对象做出选择判断，通知对象
    @Override
    public void send(String message, Colleague colleague) {
        if(colleague == colleague1){
            colleague2.notifyColleague(message);
        }else{
            colleague1.notifyColleague(message);
        }
    }


}


