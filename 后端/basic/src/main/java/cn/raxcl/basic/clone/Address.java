package cn.raxcl.basic.clone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dragon
 * @date 2022/11/19 12:01
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Cloneable{
    private String name;

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
