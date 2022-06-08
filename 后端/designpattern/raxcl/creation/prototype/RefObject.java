package raxcl.creation.prototype;

import java.io.Serializable;

/**
 * 实体类对象，用于测试深拷贝和浅拷贝
 * @author D30100_chenlong
 * @date 2022/6/7 15:44
 */
public class RefObject implements Serializable {
    private String name;
    private String address;

    public RefObject(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
