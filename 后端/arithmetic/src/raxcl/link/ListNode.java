package raxcl.link;

public class ListNode {
    public int val; //数值 data
    public ListNode next; //节点 node

    public ListNode(int x){
        val = x; //可以定义一个有参构造方法，也可以定义一个无参构造方法
    }

    //添加新的节点
    public void add(int newval){
        ListNode newNode = new ListNode(newval);
        if (this.next == null){
            this.next = newNode;
        }else {
            this.next.add(newval);
        }
    }

    //打印链表
    public void print() {
        System.out.print(this.val);
        if (this.next != null){
            System.out.print("-->");
            this.next.print();
        }
    }
}
