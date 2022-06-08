package raxcl.structure.facade;

/**
 * 外观模式客户端(由于Facade的作用，客户端可以根本不知道是哪个子系统类的存在)
 *
 * @author D30100_chenlong
 * @date 2022/6/8 14:28
 */
public class FacadeClient {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }
}
