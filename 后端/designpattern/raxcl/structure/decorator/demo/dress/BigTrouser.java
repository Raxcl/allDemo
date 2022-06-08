package raxcl.structure.decorator.demo.dress;

/**
 * 具体服饰类（ConcreteDecorator）
 *
 * @author D30100_chenlong
 * @date 2022/5/31 17:32
 */
public class BigTrouser extends Finery{
    @Override
    public void show() {
        System.out.println("垮裤");
        super.show();
    }
}
