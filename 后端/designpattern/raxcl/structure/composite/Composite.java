package raxcl.structure.composite;

import raxcl.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite定义有枝节点行为，用来存储子部件，在Component接口中实现与子部件有关的操作，比如增加add和删除remove
 *
 * @author D30100_chenlong
 * @date 2022/6/27 16:36
 */
public class Composite extends Component{
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public void display(int depth) {
        System.out.println(StringUtil.repeatableString("-",depth)+name);
        for(Component component: children){
            component.display(depth+2);
        }
    }
}
