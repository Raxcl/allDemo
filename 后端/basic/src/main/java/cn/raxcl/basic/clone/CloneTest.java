package cn.raxcl.basic.clone;

/**
 * @author dragon
 * @date 2022/11/19 12:37
 */
public class CloneTest {
    public static void main(String[] args) {
        Person person = new Person(new Address("武汉"));
        Person personCopy = person.clone();
        System.out.println(person.getAddress() == personCopy.getAddress());
    }
}
