package raxcl.structure.decorator.demo.dress;

/**
 * 具体服饰类（ConcreteDecorator）
 *
 * @author D30100_chenlong
 * @date 2022/5/31 17:32
 */
public class TShirts extends Finery{
    @Override
    public void show() {
        System.out.println("大T恤");
        super.show();
    }
}
