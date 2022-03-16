package Design;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/flatten-nested-list-iterator/

/*
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,1,2,1,1].

Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,4,6].



 */

public class NestedIterator implements Iterator<Integer> {

    interface NestedInteger{
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    Stack<Integer> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        for(int i= nestedList.size() -1; i >=0; i--){
            NestedInteger nestedInteger = nestedList.get(i);
            pushToStack(nestedInteger);
        }
    }

    private void pushToStack(NestedInteger nestedInteger){
        if(nestedInteger.isInteger()){
            stack.push(nestedInteger.getInteger());
        }else{
            List<NestedInteger> nestedList = nestedInteger.getList();
            for(int i= nestedList.size() -1; i >=0; i--){
                NestedInteger temp = nestedList.get(i);
                pushToStack(temp);
            }
        }
    }

    @Override
    public Integer next() {
        if(! stack.isEmpty())
            return stack.pop();

        return null;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();

    }
}
