package raxcl.behavior.visitor;

/**
 * ConcreteVisitor1和ConcreteVisitor2类，具体访问者，实现每个由Visitor声明的操作。
 * 每个操作实现算法的一部分，而该算法片段乃是对应于结构中对象的类。
 *
 * @author D30100_chenlong
 * @date 2022/6/30 16:51
 */
public class ConcreteVisitor1 extends Visitor{
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println(concreteElementA.getClass().getSimpleName()+"被"+this.getClass().getSimpleName()+"访问");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println(concreteElementB.getClass().getSimpleName()+"被"+this.getClass().getSimpleName()+"访问");
    }
}
