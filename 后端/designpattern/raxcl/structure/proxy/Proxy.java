package raxcl.structure.proxy;

/**
 * Proxy类，保存一个引用使得代理可以访问实体，并提供一个与Subject的接口相同的接口，这样代理就可以用来代替实体。
 *
 * @author D30100_chenlong
 * @date 2022/6/1 17:00
 */
public class Proxy extends Subject{
    RealSubject realSubjet;
    @Override
    public void request() {
       if (realSubjet == null){
           realSubjet = new RealSubject();
       }
       realSubjet.request();

    }

}
