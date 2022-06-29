package raxcl.behavior.iterator;

/**
 * 具体迭代器类，继承Iterator
 *
 * @author D30100_chenlong
 * @date 2022/6/28 10:33
 */
public class ConcreteIterator<T> implements Iterator<T>{
    //定义了一个具体聚集对象
    private ConcreteAggregate<T> aggregate;
    private int current =0;

    //初始化时将具体的聚集对象传入
    public ConcreteIterator(ConcreteAggregate<T> aggregate) {
        this.setConcreteIterator(aggregate);
    }

    private void setConcreteIterator(ConcreteAggregate<T> aggregate) {
        this.aggregate = aggregate;
    }

    //得到聚集的第一个对象
    @Override
    public T first() {
        return aggregate.getItems(0);
    }

    //得到聚集的下一个对象
    @Override
    public T next() {
        current++;
        if (current< aggregate.count()){
            return aggregate.getItems(current);
        }
        return null;
    }

    //判断当前是否遍历到结尾，到结尾返回true
    @Override
    public boolean isDone() {
        return current>=aggregate.count();
    }

    //返回当前的聚集对象
    @Override
    public T currentItem() {
        return aggregate.getItems(current);
    }
}
