package raxcl.behavior.iterator;

/**
 * 迭代器客户端
 *
 * @author D30100_chenlong
 * @date 2022/6/28 11:19
 */
public class IteratorClient {
    public static void main(String[] args) {
        //公交车，即聚集对象
        ConcreteAggregate<String> bus = new ConcreteAggregate<>();
        bus.setItems("大鸟");
        bus.setItems("小菜");
        bus.setItems("行李");
        bus.setItems("老外");
        bus.setItems("公交内部员工");
        bus.setItems("小偷");

        //售票员出场，先看好了上车的是哪些人，即声明了迭代器对象
//        Iterator<String> iterator = new ConcreteIterator<>(bus);
        Iterator<String> iterator = new ConcreteIteratorDesc<>(bus);
        while (!iterator.isDone()){
            //对面前的乘客告知请买票
            System.out.println(iterator.currentItem()+"请买车票");
            iterator.next();
        }
    }
}
