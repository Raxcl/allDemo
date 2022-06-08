package raxcl.structure.proxy;

/**
 * RealSubjet类，定义Proxy锁代表的真实实体。
 *
 * @author D30100_chenlong
 * @date 2022/6/1 16:59
 */
public class RealSubject extends Subject{
    @Override
    public void request() {
        System.out.println("真实的请求");
    }
}
