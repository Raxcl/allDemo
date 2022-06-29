package raxcl.creation.builder;

/**
 * Director类，指挥者类
 *
 * @author D30100_chenlong
 * @date 2022/6/16 18:07
 */
public class Director {
    //用来指挥建造过程
    public void construct(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
    }
}
