package raxcl.structure.adapter;

/**
 * 这是客户所期待的接口。目标可以是具体的或抽象的类，也可以是接口
 *
 * @author D30100_chenlong
 * @date 2022/6/21 13:28
 */
public class Target {
    public void request(){
        System.out.println("普通请求！");
    }
}
