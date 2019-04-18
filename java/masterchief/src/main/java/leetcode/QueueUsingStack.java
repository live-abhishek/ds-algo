package leetcode;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> stkForPush = new Stack<>();
    Stack<Integer> stkForPop = new Stack<>();
    boolean pushMode = true; // true = pushMode, false = popMode
    int headVal;

    /** Initialize your data structure here. */
    public QueueUsingStack() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (empty()) {
            headVal = x;
        }
        if (!pushMode) {
            while (!stkForPop.isEmpty()) {
                stkForPush.push(stkForPop.pop());
            }
            pushMode = true;
        }
        stkForPush.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (pushMode) {
            while (!stkForPush.isEmpty()) {
                stkForPop.push(stkForPush.pop());
            }
            pushMode = false;
        }
        Integer pop = stkForPop.pop();
        if(!empty()) {
            headVal = stkForPop.peek();
        }
        return pop;
    }

    /** Get the front element. */
    public int peek() {
        return headVal;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stkForPop.isEmpty() && stkForPush.isEmpty();
    }
}
