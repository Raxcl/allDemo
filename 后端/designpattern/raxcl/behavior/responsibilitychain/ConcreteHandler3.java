package raxcl.behavior.responsibilitychain;

/**
 * ConcreteHandler3, 当请求数在20到30之间则有权处理，否则转到下一位。
 *
 * @author D30100_chenlong
 * @date 2022/6/29 11:42
 */
public class ConcreteHandler3 extends Handler{

    @Override
    public void handleRequest(int request) {
        if (request>=20 && request<30){
            System.out.println(this.getClass().getName()+"处理请求"+request);
        }else if(successor !=null){
            //转移到下一位
            successor.handleRequest(request);
        }
    }
}
