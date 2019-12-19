package p20191216;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: 每日一题 12-15
 * User: STAR
 * Date: 2019 -12
 * Time: 16:47
 */
public class TestDemo1 {


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    @Override
    public String toString() {
        return "TestDemo1{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if(!stack2.empty()) {
            return stack2.pop();
        }
        return -1;
    }


}
