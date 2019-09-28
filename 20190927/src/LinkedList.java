

class LinkedNode {
    public int date = 0;
    public LinkedNode next= null;

    //生成一个只含有date的构造函数
    public LinkedNode(int date) {
        this.date = date;
    }
}
public class LinkedList {
    //新建一个节点，表示链表的头节点
    private LinkedNode head = null;


    //头插
    public void addFist(int elem){
        //先new一个新的节点,用于存放elem
        LinkedNode node = new LinkedNode(elem);
        //判断链表是否为空链表
        if(this.head == null){
            //空链表
            this.head = node;
            return;
        }
        //非空链表
        node.next = head;
        this.head = node;
        return;
    }

    //尾插
    public void addLast(int elem){
        LinkedNode node = new LinkedNode(elem);
        //判断是否为空链表
        if(this.head == null){
            //空链表
            this.head = node;
            return;
        }
        //非空链表
        LinkedNode cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }

    //任意位置插入节点
    public void addIndex(int index, int elem) {
        LinkedNode node = new LinkedNode(elem);
        //判断插入的链表是否在链表范围内,要知道链表的长度
        int len = size();
        if(index < 0 || index > len){
            return;
        }
        if(index == 0){//头插
            addFist(elem);
            return;
        }
        if(index == len){//尾插
            addLast(elem);
        }
        //中间任意位置，先要找到所插位置的前一个位置
        LinkedNode cur = getIbdexPos(index-1);
        node.next = cur.next;
        cur.next = node;
    }
    private LinkedNode getIbdexPos(int index){
        LinkedNode cur = this.head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur;
    }
    private int size(){
        int size = 0;
        for(LinkedNode cur = this.head; cur != null; cur = cur.next){
            size ++;
        }
        return size;
    }

    //查找2是否存于链表中
    public boolean contains(int toFind){
        for(LinkedNode cur = this.head; cur != null; cur = cur.next){
            if(cur.date == toFind){
                return true;
            }
        }
        return false;
    }

    //删除元素第一次出现的位置
    public void remove(int toRemove){
        //空链表
        if(this.head == null){
            return;
        }
        //删除头元素
        if(this.head.date == toRemove){
            this.head = this.head.next;
            return;
        }
        //删除中间元素和尾元素
        LinkedNode prv = searchPrv(toRemove);
        //prv.next = prv.next.next;
        LinkedNode nodeToRemove = prv.next;
        prv.next= nodeToRemove.next;
    }

    //删除一个元素出现的所有位置
    public void removeAllKey(int toRemove){
        if(this.head == null){
            return;
        }
        //先处理后续节点，在处理头节点
        LinkedNode prv = this.head;
        LinkedNode cur = head.next;
        while(cur != null){
            if(cur.date == toRemove){
                //删除此元素
                prv.next = cur.next;
                cur = prv.next;
            }else {
                //不用删除此元素
                prv = cur;
                cur = cur.next;
            }
        }
        //头节点处理
        if(this.head.date == toRemove){
            this.head = this.head.next;
        }
        return;
    }

    private LinkedNode searchPrv(int toRemove){
        if(this.head == null){
            return null;
        }
        for(LinkedNode cur = this.head; cur != null; cur = cur.next){
            if(cur.date == toRemove){
                return cur;
            }
        }
        return null;
    }



    //打印链表
    public void display(){
        System.out.print("[");
        for(LinkedNode node = this.head; node != null; node = node.next){
            System.out.print(node.date);
            if(node.next != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
