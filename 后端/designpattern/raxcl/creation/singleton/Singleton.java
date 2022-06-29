package raxcl.creation.singleton;

/**
 * Singleton类，定义一个getInstance操作，允许客户访问它的唯一实例。
 * getInstance是一个静态方法，主要负责创建自己的唯一实例。
 *
 * @author D30100_chenlong
 * @date 2022/6/28 14:18
 */
public class Singleton {
    //饱汉式（存在线程安全问题）
//    private static Singleton instance;
    //饿汉式（不存在线程安全问题）
    private static Singleton instance = new Singleton();

    //构造方法让其private, 这就堵死了外界利用new创建此类实例的可能。
    private Singleton(){

    }

    //此方法是获得本类实例的唯一全局访问点
    public static Singleton getInstance(){

        //若实例不存在，则new一个新实例，否则返回已有的实例
//        if (instance==null){
//            instance = new Singleton();
//        }
        //饿汉式
        return instance;
    }
}
