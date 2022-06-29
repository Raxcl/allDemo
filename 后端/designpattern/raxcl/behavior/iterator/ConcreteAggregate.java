package raxcl.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteAggregate具体聚集类
 *
 * @author D30100_chenlong
 * @date 2022/6/28 10:37
 */
public class ConcreteAggregate<T> implements Aggregate<T>{
    //声明一个List泛型变量，用于存放聚合对象，用ArrayList同样可以实现
    private List<T> items = new ArrayList<>();
    @Override
    public Iterator<T> createIterator() {
        return new ConcreteIterator<>(this);
    }
    //返回聚集总个数
    public int count(){
        return items.size();
    }

    //声明一个索引器
    public T getItems(int index){
        return items.get(index);
    }

    public void setItems(T item){
        items.add(item);
    }
}
