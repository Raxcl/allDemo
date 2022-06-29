package raxcl.creation.singleton;

/**
 * 单例模式客户端代码
 *
 * @author D30100_chenlong
 * @date 2022/6/28 14:25
 */
public class SingletonClient {
    public static void main(String[] args) {
//        Singleton s1 = Singleton.getInstance();
//        Singleton s2 = Singleton.getInstance();
        SingletonThreadSafe s1 = SingletonThreadSafe.getInstance();
        SingletonThreadSafe s2 = SingletonThreadSafe.getInstance();
        if (s1==s2){
            System.out.println("两个对象是相同的实例。");
        }
    }
}
