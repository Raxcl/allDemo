package raxcl.structure.flyweight;

import java.util.Hashtable;

/**
 * 享元工厂，用来创建并管理Flyweight对象。它主要是用来确保合理地共享Flyweight,
 * 当用户请求一个Flyweight时，FlyweightFactory对象提供一个已创建的实例或者创建一个（如果不存在的话）
 *
 * @author D30100_chenlong
 * @date 2022/6/29 16:57
 */
public class FlyweightFactory {
    private Hashtable<String, ConcreteFlyweight> flyweights = new Hashtable<>();

    //初始化工厂时，先生成三个实例
    public FlyweightFactory(){
        flyweights.put("X", new ConcreteFlyweight());
        flyweights.put("Y", new ConcreteFlyweight());
        flyweights.put("Z", new ConcreteFlyweight());
    }

    //根据客户端请求，获得已生成的实例
    public Flyweight getFlyweight(String key){
        return flyweights.get(key);
    }
}
