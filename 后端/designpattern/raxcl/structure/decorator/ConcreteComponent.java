package raxcl.structure.decorator;

/**
 * 定义了一个具体的对象，也可以给这个对象添加一些职责
 * @author D30100_chenlong
 * @date 2022/5/31 16:04
 */
public class ConcreteComponent extends Component{
    @Override
    public void operation() {
        System.out.println("具体对象的操作");
    }
}
