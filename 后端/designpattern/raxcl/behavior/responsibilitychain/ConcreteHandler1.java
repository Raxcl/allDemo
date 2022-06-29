package raxcl.behavior.responsibilitychain;

/**
 * ConcreteHandler类，具体处理者类，处理它所负责的请求，可访问它的后继者，
 * 如果可处理该请求，就处理之，否则就将该请求转发给它的后继者。
 *
 * ConcreteHandler1, 当请求数在0到10之间则有权处理，否则转到下一位。
 *
 * @author D30100_chenlong
 * @date 2022/6/29 11:42
 */
public class ConcreteHandler1 extends Handler{

    @Override
    public void handleRequest(int request) {
        if (request>=0 && request<10){
            System.out.println(this.getClass().getName()+"处理请求"+request);
        }else if(successor !=null){
            //转移到下一位
            successor.handleRequest(request);
        }
    }
}
