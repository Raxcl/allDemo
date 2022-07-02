package raxcl.behavior.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 能枚举它的元素，可以提供一个高层的接口以允许访问者访问它的元素。
 *
 * @author D30100_chenlong
 * @date 2022/6/30 17:08
 */
public class ObjectStructure {
    private List<Element> elements = new ArrayList<>();
    public void attach(Element element) {
        elements.add(element);
    }
    public void detach(Element element) {
        elements.remove(element);
    }
    public void accept(Visitor visitor) {
        for(Element element: elements) {
            element.accept(visitor);
        }
    }

}
