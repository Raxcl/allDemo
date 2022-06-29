package raxcl.creation.builder;

/**
 * Builder类，抽象建造者类，确定产品由两个部件partA和partB组成，并声明一个得到产品建造后结果的方法getResult。
 *
 * @author D30100_chenlong
 * @date 2022/6/16 17:57
 */
public abstract class Builder {
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract Product getResult();
}
