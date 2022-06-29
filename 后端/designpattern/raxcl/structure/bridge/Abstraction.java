package raxcl.structure.bridge;

/**
 * @author D30100_chenlong
 * @date 2022/6/28 17:29
 */
public class Abstraction {
    protected Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation(){
        implementor.operation();
    }
}
