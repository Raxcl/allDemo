package raxcl.behavior.visitor;

/**
 * 具体元素，实现accept操作
 *
 * @author D30100_chenlong
 * @date 2022/6/30 16:58
 */
public class ConcreteElementA extends Element{
    @Override
    public void accept(Visitor visitor) {
        //充分利用双分派技术，实现处理与数据结构的分离
        visitor.visitConcreteElementA(this);
    }

    //其他相关方法
    public void operationA(){

    }
}
