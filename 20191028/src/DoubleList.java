/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 19:17
 */


class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
        this.data = data;
    }
}

class DoubleList {

    public Node head;//头
    public Node last;//尾巴
    public DoubleList() {
        this.head = null;
        this.last = null;
    }

    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        //1、判断是否是第一次插入
        if (this.head == null) {
            this.head = node;
            this.last = node;
            return;
        }
        //2、不是第一次插入
        node.next = this.head;
        node.next.prev = node;
        this.head = node;
    }

    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
            return;
        }
        node.prev = this.last;
        this.last.next = node;
        this.last = node;

    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        Node node = new Node(data);
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("index异常");
        }
        if (index == 0) {
            addFirst(data);
            return true;
        }
        if (index == size()) {
            addLast(data);
            return true;
        }
        Node cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next.prev = node;
        cur.next = node;
        node.prev = cur;
        return true;
    }

    //查找是否包含关键字key是否在双向链表当中
    public boolean contains(int key){
        for (Node cur = this.head; cur != null; cur = cur.next) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public int remove(int key){
        Node cur = this.head;
        int oldData = -1;
        while (cur != null) {
            if(cur.data == key) {
                oldData = cur.data;
                //删除的节点是头节点
                if(cur == this.head) {
                    this.head = cur.next;
                    cur.prev = null;
                    break;
                }else if (cur != null) {
                    //不是头节点
                    this.last = cur.prev;
                    this.last.next = null;
                    break;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                    break;
                }
            }else {
                //没找到
                cur = cur.next;
            }
        }
        return oldData;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                if (this.head == cur) {
                    this.head = cur.next;
                    this.head.prev = null;
                } else {
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                    cur.prev.next = cur.next;
                }

            } else {
                cur = cur.next;
            }
        }
    }
    //得到单链表的长度
    public int size(){
        int size = 0;
        for (Node cur = this.head; cur != null; cur = cur.next) {
            size ++;
        }
        return size;
    }
    public void display(){
        System.out.print("[");
        for (Node cur = this.head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println("]");
    }
    public void clear(){
        this.head.next = null;
        this.head.prev = null;

    }

}
