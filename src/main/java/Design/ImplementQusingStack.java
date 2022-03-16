package Design;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/

/*Implement the following operations of a queue using stacks.

    push(x) -- Push element x to the back of queue.
    pop() -- Removes the element from in front of queue.
    peek() -- Get the front element.
    empty() -- Return whether the queue is empty.

Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false

Notes:

    You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
    You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).


* */

public class ImplementQusingStack {


    /** Initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> rstack;

    public ImplementQusingStack() {
        stack = new Stack<>(); // holds elements in standard order
        rstack = new Stack<>(); // holds elements in reverse order
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        rstack.push(x);
        sort();
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        /*if(rstack.size() > 0 && stack.size() == 0){
            sort();
        }*/

        return stack.pop();

    }

    /** Get the front element. */
    public int peek() {
        /*if(rstack.size() > 0 && stack.size() == 0){
            sort();
        }*/


        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && rstack.isEmpty();
    }

    private void sort(){
        if(stack.isEmpty()){
            while(!rstack.isEmpty())
                stack.push(rstack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */