package raxcl.behavior.template;

/**
 * 实现了一个模板方法，定义了算法的骨架，具体子类将重定义primitiveOperation以实现一个算法的步骤
 * @author D30100_chenlong
 * @date 2022/6/8 13:50
 */
public abstract class AbstractTemplate {
    //一些抽象行为，放到子类去实现
    public abstract void primitiveOperation1();
    public abstract void primitiveOperation2();

    //模板方法，给出了逻辑的骨架，而逻辑的组成是一些相应的抽象操作，他们都推迟到子类实现
    public void templateMethod(){
        primitiveOperation1();
        primitiveOperation2();
    }
}
