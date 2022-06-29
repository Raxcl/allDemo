package raxcl.behavior.responsibilitychain;

/**
 * Handler类，定义一个处理请示的接口
 *
 * @author D30100_chenlong
 * @date 2022/6/29 11:26
 */
public abstract class Handler {
    protected Handler successor;
    //设置继承者
    public void setSuccessor(Handler successor){
        this.successor = successor;
    }
    //处理请求的抽象方法
    public abstract void handleRequest(int request);
}
