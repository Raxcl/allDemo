package raxcl.structure.decorator.demo.dress;

/**
 * Person类（ConcreteComponent）
 * @author D30100_chenlong
 * @date 2022/5/31 17:10
 */
public class Person {

    public Person(){};
    private String name;
    public  Person(String name){
        this.name = name;
    }

    public void show(){
        System.out.println("装扮的"+name);
    }
}
