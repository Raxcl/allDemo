package cn.raxcl.basic.io.ziJie;

import java.io.Serializable;

/**
 * @author D30100_chenlong
 * date 2022/7/31 10:49
 */
public class Person implements Serializable {
    private String name;
    private String res;
    public Person(String name, String res) {
        this.name = name;
        this.res = res;
    }
}
