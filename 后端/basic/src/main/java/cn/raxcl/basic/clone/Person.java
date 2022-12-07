package cn.raxcl.basic.clone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dragon
 * @date 2022/11/19 12:36
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Cloneable{
    private Address address;

    @Override
    public Person clone() {
        try {
            // 浅拷贝
//            return (Person) super.clone();
            // 深拷贝
            Person person = (Person) super.clone();
            person.setAddress(person.address.clone());
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
