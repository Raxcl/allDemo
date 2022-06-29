package raxcl.structure.composite;

import raxcl.util.StringUtil;

/**
 * Leaf在组合中表示叶子节点对象，叶子节点没有子节点。
 *
 * @author D30100_chenlong
 * @date 2022/6/27 16:26
 */
public class Leaf extends Component{
    public Leaf(String name) {
        super(name);
    }

    /**
     * 由于叶子没有再增加分枝和树叶，所以add和remove方法实现它没有意思，
     * 但这样做可以消除叶节点和枝节点对象在抽象层次的区别，他们具备完全一致的接口。
     * @param c
     */
    @Override
    public void add(Component c) {
        System.out.println("cannot add to a leaf");
    }

    @Override
    public void remove(Component c) {
        System.out.println("cannot remove to a leaf");
    }

    //叶节点的具体方法，此处是显示其名称和级别
    @Override
    public void display(int depth) {
        System.out.println(StringUtil.repeatableString("-",depth)+name);
    }
}
