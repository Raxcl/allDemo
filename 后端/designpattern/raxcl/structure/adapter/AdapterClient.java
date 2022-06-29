package raxcl.structure.adapter;

/**
 * 适配器模式客户端
 *
 * @author D30100_chenlong
 * @date 2022/6/21 13:36
 */
public class AdapterClient {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
