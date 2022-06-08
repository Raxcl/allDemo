package raxcl.structure.decorator.demo.dress;

/**
 * 服饰类（Decorator）
 * @author D30100_chenlong
 * @date 2022/5/31 17:20
 */
public class Finery extends Person{
    private Person component;

    //打扮
    public void decorate(Person component){
        this.component = component;
    }


    @Override
    public void show() {
        if (component!=null){
            component.show();
        }
    }
}
