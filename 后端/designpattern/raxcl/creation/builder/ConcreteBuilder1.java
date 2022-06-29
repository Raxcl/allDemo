package raxcl.creation.builder;

/**
 * ConcreteBuilder类，具体建造者类
 *
 * @author D30100_chenlong
 * @date 2022/6/16 18:02
 */
public class ConcreteBuilder1 extends Builder{
    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("部件A");
    }

    @Override
    public void buildPartB() {
        product.add("部件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
