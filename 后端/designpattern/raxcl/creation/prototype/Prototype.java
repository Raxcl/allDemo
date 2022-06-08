package raxcl.creation.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * (实现自带抽象类Cloneable)抽象类关键就是有这样一个Clone方法
 * @author D30100_chenlong
 * @date 2022/6/7 14:08
 */
public class Prototype implements Cloneable,Serializable{
    private String name;
    private RefObject refObject;

    public Prototype(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public RefObject getRefObject() {
        return refObject;
    }

    public void setRefObject(RefObject refObject) {
        this.refObject = refObject;
    }

    //浅拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流内
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        //从流内读出对象
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        return ois.readObject();
    }

}
