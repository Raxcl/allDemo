package raxcl.structure.map;

import java.util.*;

/**
 * 迭代map的几种方式
 *
 * @author D30100_chenlong
 * @date 2022/5/17 10:39
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, Character> map = new HashMap<Integer, Character>();
        map.put(1,'c');
        map.put(2,'q');
        map.put(4,'d');
        map.put(3,'x');
        //方式一：遍历hashmap entry foreach
        Set<Map.Entry<Integer,Character>> ent = map.entrySet();
//        Iterator<Map.Entry<Integer, Character>> iterator = map.entrySet().iterator();
        for(Map.Entry<Integer, Character> entry : ent){
            System.out.print(entry.getKey() + ":" + entry.getValue()+"  ");
        }
        System.out.println();
        //方式二:通过keySet或者values()遍历
        Set<Integer> set = map.keySet();
        for (Integer key: set){
            System.out.print(key+":"+map.get(key)+"  ");
        }
        System.out.println();
        //方式三：通过Collection工具类遍历值
        //todo 有没有办法遍历key？
        Collection<Character> set1 = map.values();
        for (Character val: set1){
            System.out.print(val+"  ");
        }
        System.out.println();
        //iterator原理是什么? 通过iterator遍历map
        //方式4：通过迭代器Iterator遍历
        Iterator<Map.Entry<Integer,Character>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer, Character> entry = iter.next();
            System.out.print(entry.getKey()+ ":"+entry.getValue()+"  ");
//            iter.remove();
        }
        System.out.println();
        //方式5：通过迭代器获取key
        Iterator<Integer> keys = map.keySet().iterator();
        while(keys.hasNext()){
            int k = keys.next();
            System.out.print(k+ ":" + map.get(k)+"  ");
        }
    }
}
