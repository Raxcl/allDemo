package raxcl.LRU;

/**
 * @author D30100_chenlong
 * @date 2022/4/21 11:21
 */
public class Node {
    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Node pre;
    public Node next;
    public String key;
    public String value;
}
