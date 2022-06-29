package raxcl.creation.singleton;

/**
 * @author D30100_chenlong
 * @date 2022/6/28 14:50
 */
public class SingletonThreadSafe {
    private static volatile SingletonThreadSafe instance;

    //构造方法让其private, 这就堵死了外界利用new创建此类实例的可能。
    private SingletonThreadSafe(){

    }

    //此方法是获得本类实例的唯一全局访问点
    public static SingletonThreadSafe getInstance(){

        //若实例不存在，则new一个新实例，否则返回已有的实例
        if (instance==null){
            synchronized (SingletonThreadSafe.class){
                if (instance==null){
                    instance = new SingletonThreadSafe();
                }
            }
        }
        return instance;
    }
}
