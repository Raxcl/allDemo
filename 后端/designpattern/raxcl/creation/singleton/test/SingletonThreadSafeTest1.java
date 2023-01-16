package raxcl.creation.singleton.test;

public class SingletonThreadSafeTest1 {
    private static volatile SingletonThreadSafeTest1 instance;

    private SingletonThreadSafeTest1(){

    }

    public static SingletonThreadSafeTest1 getInstance(){
        if (instance == null) {
            synchronized (SingletonThreadSafeTest1.class) {
                if (instance == null) {
                    instance = new SingletonThreadSafeTest1();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonThreadSafeTest1 instance1 = SingletonThreadSafeTest1.getInstance();
        System.out.println(instance1);
    }
}
