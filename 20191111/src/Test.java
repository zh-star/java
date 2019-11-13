import java.sql.SQLOutput;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 21:13
 */
public class Test {
    public static void main(String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.poll());//出队1
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());
    }
    public static void main1(String[] args){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.isEmpty());
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.peek());
        System.out.println(myStack.isFull());
    }
}
