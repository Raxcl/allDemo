package raxcl.behavior.visitor;

/**
 * Element类，定义一个Accept操作，它以一个访问者为参数。
 *
 * @author D30100_chenlong
 * @date 2022/6/30 16:56
 */
public abstract class Element {
    public abstract void accept(Visitor visitor);
}
