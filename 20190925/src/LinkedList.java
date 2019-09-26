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


    //任意位置插入节点
    public void addIndex(int index,int elem){
        LinkedNode node = new LinkedNode(elem);
        //先对index进行合法性校验，需要计算链表的长度
        int len = size();
        if(index < 0 || index > len) {
            return;
        }
        if(index == 0){
            //头插
            addFist(elem);
            return;
        }
        if(index == len){
            //尾插
            addLast(elem);
        }
        //链表中间插入
        //prv找到index - 1对应的位置
        LinkedNode prv = getIndexPos(index - 1);
        node.next = prv.next;
        prv.next = node;
    }


    //求链表的长度
    private int size(){
        int size = 0;
        for(LinkedNode cur = this.head; cur != null; cur = cur.next){
            size ++;
        }
        return size;
    }
    //找到链表中index的前一个位置，并返回index前一个位置的引用
    private LinkedNode getIndexPos(int index){
        LinkedNode cur = this.head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur;
    }


    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int toFind){
        for(LinkedNode cur = this.head; cur != null; cur = cur.next){
            if(cur.date == toFind){
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为elem的节点
    public void remove(int toRemove){
        //LinkedNode cur = new LinkedNode(elem);
        //先要判断链表是否为空
        if(this.head == null){
            return;
        }
        //删除节点为第一个节点
        if(this.head.date == toRemove){
            this.head = this.head.next;
        }
        //删除中间元素或最后一个元素
        LinkedNode prv = searchPrv(toRemove);
        prv.next = prv.next.next;
    }

    private LinkedNode searchPrv(int toRemove){
        //空链表校验
        if(this.head == null){
            return null;
        }
        LinkedNode cur = this.head;
        while(cur.next != null) {
            if(cur.next.date == toRemove)
            {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }


}
