/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 19:51
 */
class DlinkedNode {
    public int val;
    public DlinkedNode prev = null;
    public DlinkedNode next = null;

    public DlinkedNode(int val) {
        this.val = val;
    }
}
public class DlinkedList {
    private DlinkedNode head = null;
    public DlinkedList() {
        head = new DlinkedNode(-1);
        head.next = head;
        head.prev = head;
    }

    public void addFirst(int data){
        DlinkedNode node = new DlinkedNode(data);
        //1、判断是否是第一次插入
        if (this.head == null) {
            this.head = node;
            return;
        }
        //2、不是第一次插入
        node.next = this.head;
        node.next.prev = node;
        this.head = node;
    }
    public void display(){
        System.out.print("[");
        for (DlinkedNode cur = this.head.next; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }
        System.out.println("]");
    }
}
