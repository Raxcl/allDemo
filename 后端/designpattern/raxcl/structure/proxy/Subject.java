package raxcl.structure.proxy;

/**
 * Subject类，定义了RealSubject和Proxy的共用接口，这样就在任何使用RealSubject的地方都可以使用Proxy.
 *
 * @author D30100_chenlong
 * @date 2022/6/1 16:51
 */
public abstract class Subject {
    public abstract void request();
}
