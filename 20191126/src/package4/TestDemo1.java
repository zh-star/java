package package4;

/**
 * Created with IntelliJ IDEA.
 * Description:内部类-》类的内部
 * User: GAOBO
 * Date: 2019-12-02
 * Time: 18:48
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 内部类：
 * 实例内部类
 * 静态内部类
 * 匿名内部类
 * 本地内部类--》基本上不会考或者用方法里边
 */
class OuterClass {
    public int data1 = 10;
    public static int data2 = 20;

    /**
     * 实例内部类
     * 面试问题：
     * 1、如何拿到实例内部类的对象？
     * 2、在实例内部类当中，是否可以定义static的数据成员？
     *   不能！！-》错误的！
     *   static final -》必须是在编译时期确定的！
     * 3、内部类可以访问外部类的所有数据成员，包括私有的。
     * 4、实例内部类是否有额外的开销？包含了外部类的this
     * InnerClass是OuterClass 的 成员
     * OuterClass.this->拿到外部类的对象的引用
     */
    class InnerClass {
        public int data3 = 100;
        public static final int data4 = 200;
        public int data1 = 10000;
        public InnerClass() {
        }
        public void func() {
            System.out.println("InnerClass::func()");
            System.out.println("data1: "+ this.data1);
            System.out.println("data2: "+ data2);
            System.out.println("data3: "+ data3);
            System.out.println("data4: "+ data4);
            System.out.println("Outerdata1: "+
                    OuterClass.this.data1);
        }
    }
}

class OuterClass2 {
    public int data1 = 10;
    public static int data2 = 20;

    /**
     * 静态内部类-》static
     * 1、如何拿到静态内部类的实例对象？
     *
     */
    static class InnerClass2{
        public int data3 = 200;
        public static int data4 = 100;
        public int data1 = 300;
        OuterClass2 o = null;

        public InnerClass2() {

        }

        public InnerClass2(OuterClass2 out) {
            this.o = out;
        }
        public void func() {
            System.out.println("InnerClass2::func()");
            System.out.println("data3: "+data3);
            System.out.println("data4: "+data4);
            System.out.println("data1: "+ data1);
            System.out.println("data2: "+ data2);
            //面试问题：静态内部类能否访问外部类的实例成员，不能直接访问
            //System.out.println("outdata1: "+ OuterClass2.this.data1);
            System.out.println("outdata1: "+ o.data1);
        }
    }
}
//匿名内部类-》线程
class MyThread {
    public void func() {
        System.out.println("out::MyThread::func()");
    }
}
public class TestDemo1 {

    public static<T extends Comparable<T>> TestLink.Node<T>
    mergeList(TestLink.Node<T> headA,
              TestLink.Node<T> headB) {

        /*TestLink testLink = new TestLink();
        TestLink.Node newHead = testLink.new Node();*/
        TestLink.Node<T> newHead = new TestLink.Node<>();

        TestLink.Node<T> tmp = newHead;

        while (headA != null && headB != null) {
            if(headA.data .compareTo(headB.data)<0 ) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headA != null) {
            tmp.next = headA;
        }
        if(headB != null) {
            tmp.next = headB;
        }
        return newHead.next;
    }

    public static void main(String[] args) {

        TestLink<Integer> testLink = new TestLink<>();
        testLink.addLast(10);
        testLink.addLast(20);
        testLink.addLast(30);
        testLink.addLast(40);
        testLink.addLast(50);
        testLink.display();

        TestLink<Integer> testLink2 = new TestLink<>();
        testLink2.addLast(10);
        testLink2.addLast(20);
        testLink2.addLast(30);
        testLink2.addLast(40);
        testLink2.addLast(50);
        testLink2.display();

        TestLink.Node newHead =
                mergeList(testLink.head,testLink2.head);
        testLink2.display2(newHead);

    }


    public static void main3(String[] args) {
        //new MyThread();//匿名对象
        /**
         * 匿名内部类-》MyThread的一个子类
         */
        new MyThread(){
            @Override
            public void func() {
                //super.func();
                System.out.println("inner::MyThread::func()");
            }
        }.func();
    }


    public static void main2(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        //外部类名.静态内部类名  in = new 外部类类名.内部类();
        OuterClass2.InnerClass2 innerClass2 =
                new OuterClass2.InnerClass2(outerClass2);

        innerClass2.func();
        //int ret = OuterClass2.InnerClass2.data4;
        //System.out.println(ret);
    }

    public static void main1(String[] args) {

        OuterClass outerClass = new OuterClass();
        //实例内部类的对象
        // 外部类名.实例内部类名  in   =  外部类对象的引用.new 内部类对象
        OuterClass.InnerClass in = outerClass.new InnerClass();
        in.func();
    }
}
