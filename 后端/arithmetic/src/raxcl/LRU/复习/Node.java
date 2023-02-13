package raxcl.LRU.复习;

public class Node {
    public String key;
    public String value;
    public Node pre;
    public Node next;
    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
