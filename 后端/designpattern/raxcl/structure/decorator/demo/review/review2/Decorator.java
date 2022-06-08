package raxcl.structure.decorator.demo.review.review2;


/**
 * 装饰抽象类，继承了Component,从外类来扩展Component类的功能,但对于Component来说，是无需知道Decorator的存在的。
 * @author D30100_chenlong
 * @date 2022/6/1 16:06
 */
public class Decorator extends Component {
    private Component component;

    public void setComponent(Component component){
        this.component = component;
    }
    @Override
    public void operation() {
        if (component!=null){
            component.operation();
        }
    }
}
