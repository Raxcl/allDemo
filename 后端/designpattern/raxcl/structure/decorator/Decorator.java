package raxcl.structure.decorator;

/**
 * 装饰抽象类，继承了Component,从外类来扩展Component类的功能,但对于Component来说，是无需知道Decorator的存在的。
 * @author D30100_chenlong
 * @date 2022/5/31 16:06
 */
public class Decorator extends Component{
    private Component component;
    //设置Component
    public void setComponent(Component component){
        this.component = component;
    }

    //重写Operation(), 实际执行的是Component的Operation()
    @Override
    public void operation() {
        if (component != null){
            component.operation();
        }
    }
}
