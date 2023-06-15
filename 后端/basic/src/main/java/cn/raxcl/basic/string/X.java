package cn.raxcl.basic.string;

/**
 * @author D30100_chenlong
 * @date 2023/4/7 10:07
 */
public class X{
    public X aMethod(){
        return this;
    }


}

class Y extends X{
    public X aMethod(){return new Y();}
}
