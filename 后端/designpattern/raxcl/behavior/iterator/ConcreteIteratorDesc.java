package raxcl.behavior.iterator;

/**
 * 反向迭代
 *
 * @author D30100_chenlong
 * @date 2022/6/28 11:57
 */
public class ConcreteIteratorDesc<T> implements Iterator<T>{
    private ConcreteAggregate<T> aggregate;
    private int current =0;

    public ConcreteIteratorDesc(ConcreteAggregate<T> aggregate) {
        this.aggregate = aggregate;
        current = aggregate.count()-1;
    }

    @Override
    public T first() {
        return aggregate.getItems(aggregate.count()-1);
    }

    @Override
    public T next() {
        current--;
        if (current>0){
            return aggregate.getItems(current);
        }
        return null;
    }

    @Override
    public boolean isDone() {
        return current<0;
    }

    @Override
    public T currentItem() {
        return aggregate.getItems(current);
    }
}
