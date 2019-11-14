package package2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 9:43
 */
class MyStack {

    public Queue<Integer> queue1 ;

    public Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.isEmpty() && queue2.isEmpty()){
            queue1.offer(x);
        } else if(queue1.isEmpty()){
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) {
            return -1;
        }
        int oldData;
        if(!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++) {
                queue2.offer(queue1.poll());
            }
            oldData =  queue1.poll();
        } else {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++) {
                queue1.offer(queue2.poll());
            }
            oldData =  queue2.poll();
        }
        return oldData;
    }

    /** Get the top element. */
    public int top() {
        if(empty()) {
            return -1;
        }
        int oldData = 0;
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size ; i++) {
                oldData = queue1.poll();
                queue2.offer(oldData);
            }
        }else if(!queue2.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size ; i++) {
                oldData = queue2.poll();
                queue1.offer(oldData);
            }
        }
        return oldData;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }
}
public class Test {
    public static void main(String[] args){

    }
    public static boolean vivad(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(' || str.charAt(i) == '['|| str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else {
                if(stack.empty()) {
                    return false;
                } else {
                    char ch = stack.peek();
                    if(ch == '(' && str.charAt(i) == ')' || ch == '[' && str.charAt(i) == ']'
                        || ch == '{' && str.charAt(i) == '}') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }

            }
        }
        if(!stack.empty()) {
            //左括号多
            return false;
        }
        return true;
    }
}
