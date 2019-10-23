/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 9:38
 */
class Node {
    public int data;
    public Node next;

    public Node() {
    }
    public Node(int date) {
        this.data = date;
    }
}
public class LinkedList {
    public Node head;

    //1.头插
    public void addFirst(int date) {
        Node node = new Node(date);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    //2.尾插
    public void addLast (int date) {
        Node node = new Node(date);
        if(this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //3.打印
    public void display(Node head) {
        System.out.print("[");
        for (Node cur = head; cur !=null; cur = cur.next) {
            System.out.print(cur.data);
            if(cur.next != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public void display(){
        System.out.print("[");
        for (Node cur = this.head; cur !=null; cur = cur.next) {
            System.out.print(cur.data);
            if(cur.next != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
    /**
     * 找到index-1位置的节点
     * 返回的是index-1位置的节点的引用
     * @param index
     * @return
     */
    private Node searchIndex(int index) {
        int count = 0;
        Node cur = this.head;
        while (count < index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //4.任意位置插入
    public boolean addIndex(int index,int data){
        Node node = new Node(data);
        if(index < 0  || index > getLength()+1) {
            throw new  IndexOutOfBoundsException("下表不合法");
        }
        if(index == 0) {
            addFirst(data);
            return true;
        }
        //1、找到index位置的前驱
        Node prev = searchIndex(index);
        //2、插入
        node.next = prev.next;
        prev.next = node;
        return true;
    }

    //求链表长度
    private int getLength() {
        int length = 0;
        for (Node cur = this.head; cur != null; cur = cur.next) {
            length ++;
        }
        return length;
    }

    //5.查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        for (Node cur = this.head; cur != null; cur = cur.next) {
            if(cur.data == key) {
                return true;
            }
        }
        return false;
    }

    private Node searchPrev(int key) {
        for (Node prev = this.head; prev.next != null; prev = prev.next) {
            if(prev.next.data == key) {
                return prev;
            }
        }
        return null;
    }
    //6.删除第一次出现关键字为key的节点
    public void remove(int key){
        //1、删除的节点是头节点
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //2、不是头节点
        Node prev = searchPrev(key);
        if(prev == null) {
            return;
        }
        Node cur = prev.next;
        //删除
        prev.next = cur.next;

    }

    //1题：删除所有值为key的节点
    public void removeAllKey(int key){

        Node prev = this.head;//cur的前驱
        Node cur = this.head.next;//要删除的节点

        while (cur != null) {
            if(prev.next.data == key) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key) {

            this.head = this.head.next;
        }
    }
    //2题：反转一个链表
    public Node reverseList() {
        if(this.head == null || this.head.next == null) {
            return this.head;
        }
        Node prev = null;
        Node cur = this.head;
        Node curNext = this.head.next;
        while(cur != null) {
            //反转
            cur.next = prev;
            if(curNext == null) {
                this.head = cur;
                break;
            }
            //更新引用
            prev = cur;
            cur = curNext;
            curNext = cur.next;
        }
        return this.head;
    }

    //3题：给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
    //如果有两个中间结点，则返回第二个中间结点。
    public Node middleNode1() {
        int len = getLength() / 2;
        Node cur = this.head;
        for (int i = 0; i < len; i++) {
            cur = cur.next;
        }
        return cur;
    }
    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //4题：输入一个链表，输出该链表中倒数第k个结点
    public Node findKthToTail(int k) {
        if(k < 0 || k > getLength()) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        for (int i = 0; i < k -1; i++) {
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //6题：编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node cur = this.head;
        while (cur != null) {
            if(cur.data < x) {
                //若没有这两行，牛客网不能通过，
                Node curNext = cur.next;
                cur.next = null;
                //第一次插入到beforeStart
                if(beforeStart == null) {
                    beforeStart = cur;
                    beforeEnd = cur;
                }else {
                    beforeEnd.next = cur;
                    beforeEnd = beforeEnd.next;
                }
            }else {//cur.data >= x
                if(afterStart == null) {
                    afterStart = cur;
                    afterEnd = cur;
                }else {
                    afterEnd.next = cur;
                    afterEnd = afterEnd.next;
                }
            }
            cur = cur.next;
        }
        if(beforeEnd == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }

}
