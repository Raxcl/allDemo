package raxcl.behavior.iterator;

/**
 * Aggregate聚集接口
 *
 * @author D30100_chenlong
 * @date 2022/6/28 10:31
 */
public interface Aggregate<T> {
    //创建迭代器
    public Iterator<T> createIterator();
}
