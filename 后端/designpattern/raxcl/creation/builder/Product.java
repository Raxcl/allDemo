package raxcl.creation.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Product类，产品类，由多个部分组成。
 *
 * @author D30100_chenlong
 * @date 2022/6/16 17:46
 */
public class Product {
    List<String> parts = new ArrayList<>();

    //添加产品部件
    public void add(String part){
        parts.add(part);
    }

    //列举所有的产品部件
    public void show(){
        System.out.println("产品 创建 ----");
        for (String part: parts){
            System.out.println(part);
        }
    }
}
