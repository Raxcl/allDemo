package raxcl.structure.composite;

/**
 * CompositeClient
 *
 * @author D30100_chenlong
 * @date 2022/6/27 16:56
 */
public class CompositeClient {
    public static void main(String[] args) {
        //生成树根root，根上长出两叶LeafA和LeafB
        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));

        //根上长出分枝CompositeX,分枝上也有两叶LeafXA和LeafXB.
        Composite comp = new Composite("Composite X");
        comp.add(new Leaf("Leaf XA"));
        comp.add(new Leaf("Leaf XB"));
        root.add(comp);

        Composite comp2 = new Composite("Composite XY");
        comp2.add(new Leaf("Leaf XYA"));
        comp2.add(new Leaf("Leaf XYB"));
        comp.add(comp2);

        root.add(new Leaf("Leaf C"));
        Leaf leaf = new Leaf("Leaf D");
        root.add(leaf);
        root.remove(leaf);

        //显示大树的样子
        root.display(1);
    }
}
