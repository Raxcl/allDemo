package raxcl.structure.decorator.demo.review.review2;

/**
 * 定义了一个具体的对象，也可以给这个对象添加一些职责
 * @author D30100_chenlong
 * @date 2022/6/6 15:58
 */
public class ConcreteComponent extends Component{
    @Override
    public void operation() {
        System.out.println("具体对象的操作");
    }
}
