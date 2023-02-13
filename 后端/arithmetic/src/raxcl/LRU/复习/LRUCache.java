package raxcl.LRU.复习;

import java.util.HashMap;

public class LRUCache {
    private Node head;
    private Node end;
    // 缓存存储上线
    private int limit;
    private HashMap<String, Node> hashMap;

    public LRUCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            node.value = value;
            refreshNode(node);
        }
    }

    private void refreshNode(Node node) {
        // 如果访问的是尾节点，则无须移动节点
        if (end == node) {
            return;
        }
        removeNode(node);
        addNode(node);
    }

    private void addNode(Node node) {
        // 如果链表不为空
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }
    }

    private String removeNode(Node node) {
        if (node == head && node == end){
            // 移除唯一的节点
            head = null;
            end = null;
        } else if (node == end){
            // 移除尾节点
            end = end.pre;
            end.next = null;
        } else if (node == head) {
            // 移除头节点
            head = head.next;
            head.pre = null;
        } else {
            // 移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    public static void main(String[] args) {
        raxcl.LRU.LRUCache lruCache = new raxcl.LRU.LRUCache(5);
        lruCache.put("001", "用户1信息");
        lruCache.put("002", "用户2信息");
        lruCache.put("003", "用户3信息");
        lruCache.put("004", "用户4信息");
        lruCache.put("005", "用户5信息");
        lruCache.get("001");
        lruCache.put("004", "用户4信息更新");
        lruCache.put("006", "用户6信息");
        System.out.println(lruCache.get("002"));
        System.out.println(lruCache.get("004"));
        System.out.println(lruCache.get("006"));
    }

}
