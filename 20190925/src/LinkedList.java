class LinkedNode {
    public int date = 0;
    public LinkedNode next = null;

    public LinkedNode(int date){
        this.date = date;//this关键字表示当前对象引用
    }
}
public class LinkedList {
    //创建一个头节点（第一个节点），有了这个节点就可以根据next找到剩下的所有元素
    private LinkedNode head = null;

    //头插进行插入元素
    public void addFist(int elem) {
        //新建一个节点，用于存放要插入的元素
        LinkedNode node = new LinkedNode(elem);
        if(this.head== null) {
            //空链表的情况
            this.head = node;
            return;
        }
        //不是空链表的情况
        node.next = head;
        this.head = node;
    }


    //尾插法插入一个节点
    public void addLast(int elem) {
        LinkedNode node = new LinkedNode(elem);
        if(this.head == null) {
            //空链表
            this.head = node;
            return;
        }
        //非空链表
        LinkedNode cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public void display() {
        //打印链表中所有元素
        System.out.print("[");
        for(LinkedNode node = this.head; node != null; node = node.next) {
            System.out.print(node.date);
            if(node.next != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        return;
    }
}
