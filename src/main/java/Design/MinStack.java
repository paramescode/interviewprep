package Design;

import java.util.LinkedList;

//https://leetcode.com/problems/min-stack/submissions/

class MinStack {

    /** initialize your data structure here. */

    class Element{
        int val;
        int min;

        Element(int min, int val){
            this.min = min;
            this.val = val;
        }
    }

    LinkedList<Element> stack = null;
    Element top = null;

    public MinStack() {
        stack = new LinkedList<>();

    }

    public void push(int x) {
        if(top == null){
            Element e = new Element(x,x);
            top = e;
            stack.addLast(e);
            System.out.println(" top " + top.min);
        }else{
            Element e = new Element(Math.min(x, top.min), x);
            top = e;
            stack.addLast(e);
            System.out.println(" top " + top.min);
        }

    }

    public void pop() {
        if(stack.size() > 0){
            Element e = stack.pollLast();
            //System.out.println("remove :" + e.val);
        }

        if(stack.size() > 0){
            top = stack.peekLast();
            System.out.println(" top peek " + top.min);
        }
        else
            top = null;

    }

    public Integer top() {
        if(top != null)
            return top.val;

        return null;
    }

    public Integer getMin() {

        if(top != null)
            return top.min;

        return null;

        //return res;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
