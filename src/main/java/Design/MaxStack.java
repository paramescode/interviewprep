package Design;

import java.util.Stack;

public class MaxStack {

    class Element{
        int val;
        int max;
        Element(int val, int max){

        }
    }

    Stack<Element> stack = null;
    Element top = null;

    MaxStack(){
        stack = new Stack<>();
    }

    public void push(int x){
        Element e = null;
        if(stack.isEmpty()){
            e = new Element(x,x);
        }else{
            e = new Element(x, Math.max(x, top.max));

        }

        top = e;
        stack.push(e);
    }
    public  void pop(){
        if(stack.size() >0){
            Element e = stack.pop();

            if(stack.isEmpty())
                top = null;
            else
                top = stack.peek();

        }


    }

    public Integer top(){
        if(top != null)
            return top.val;

        return null;

    }

    public Integer getMax(){

        if(top != null)
            return top.max;

        return null;
    }

    public void popMax(){

        int max = top.max;

        Stack<Element> tstack = new Stack<>();
        while(!stack.isEmpty() && stack.peek().val != max){
            tstack.push(stack.pop());
        }

        if(!stack.isEmpty() && stack.peek().val == max){
            stack.pop();
        }

        while(!tstack.isEmpty()){
            stack.push(tstack.pop());
        }

    }

}
