package raxcl.behavior.iterator;

/**
 * Iterator迭代器接口
 * @author D30100_chenlong
 * @date 2022/6/28 10:27
 */
public interface Iterator<T> {
    //用于定义得到开始对象、得到下一个对象、判断是否到结尾、当前对象等抽象方法，统一接口
    public T first();
    public T next();
    public boolean isDone();
    public T currentItem();


}
