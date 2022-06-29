package raxcl.structure.adapter;

/**
 * 通过在内部包装一个Adaptee对象，把原接口转换成目标接口
 *
 * @author D30100_chenlong
 * @date 2022/6/21 13:32
 */
public class Adapter extends Target{
    //建立一个私有的Adaptee对象
    private Adaptee adaptee = new Adaptee();

    //这样就可以把表面上调用request()方法变成实际调用specificRequest()
    @Override
    public void request() {
        adaptee.specificRrquest();
    }

}
