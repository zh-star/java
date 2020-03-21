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
        //处理头结点
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

    //7.删除链表中的重复节点
    public Node deleteDuplication() {
        Node newHead = new Node(-1);
        Node tmp = newHead;
        Node cur = this.head;
        while (cur != null) {
            //代表找到相同的节点
            if(cur.next != null &&
                    cur.data == cur.next.data) {
                while (cur.next != null &&
                        cur.data == cur.next.data) {
                    cur =cur.next;
                }
                cur = cur.next;
                tmp.next = cur;
            }else {
                //没有找到相同的节点
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    //8.链表的回文
    /**
     * 1、定义两个引用，目的：找到单链表的中间位置
     * 2、进行翻转，翻转的是后半部分
     * 3、一个head从头开始走，slow从尾巴开始走
     * 4、只要发现对应的data不相同，那么就不是回文
     * @return
     */
    public boolean chkPalindrome(){
        if(this.head == null) {
            return false;
        }
        if(this.head.next == null)  {
            return true;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //循环结束。slow为链表的中间节点
        Node p = slow.next;
        while(p != null) {
            Node pNext = p.next;
            p.next = slow;
            slow = p;
            p = pNext;
            if(p != null) {
                pNext = p.next;
            }
        }
        while(head != slow) {
            if(head.data != slow.data) {
                return false;
            }
            if(this.head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    //9.判断链表是否有环
    public static Node getIntersectionNode(Node headA,Node headB){
        int lenA = 0;
        int lenB = 0;
        Node pL = headA;//长的
        Node pS = headB;//短的
        // 1.求出两个链表的长度
        while (pL != null) {
            lenA++;
            pL = pL.next;
        }

        while (pS != null) {
            lenB++;
            pS = pS.next;
        }
        // 如果链表A长，
        int len = lenA - lenB;
        if(len < 0) {
            pL = headB;
            pS = headA;
            len = lenB-lenA;
        }

        pL = headA;
        pS = headB;

        //pL肯定指向最长的单链表
        //pS肯定指向最短的单链表
        //len  肯定是一个正数

        for (int i = 0; i < len; i++) {
            pL = pL.next;
        }
        //pL和pS此时已经在同一期起跑线上了
        //可以一人一步走
        return  null;
    }
}
