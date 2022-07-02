package raxcl.behavior.visitor;

/**
 * 为该对象结构中ConcreteElement的每一个类声明一个Visit操作。
 *
 * @author D30100_chenlong
 * @date 2022/6/30 16:41
 */
public abstract class Visitor {
    public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);
    public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);
}
