/**
 * Created with IntelliJ IDEA.
 * Description:我的队列
 * User: STAR
 * Date: 2019 -11
 * Time: 21:19
 */
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class MyQueue {
    private Node head;
    private Node tail;
    private int usedSize;
    //入队
    public void offer(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            this.tail = head;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }
        this.usedSize ++;

    }
    //出队
    public int poll() {
        if(this.head == null) {
            return  -1;
        }
        int oldData = this.head.data;
        this.head = this.head.next;
        this.usedSize --;
        return oldData;
    }

    //得到队列的队头元素 并且不删除
    public int peek() {
        return this.head.data;
    }
    //size
    public int size() {
        return this.usedSize;
    }
}
