package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalIterativeMethod {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        while(true){
            while( root != null){
                //System.out.println(root.val);
                stack.push(root);
                stack.push(root);
                //System.out.println(stack.size());
                root = root.left;
            }

            if(stack.isEmpty())
                break;

            root = stack.pop();

            if(!stack.isEmpty() && root == stack.peek()){
                root = root.right;
            }else{
                //System.out.println(root.val + " " + stack.peek().val);
                res.add(root.val);
                root = null;

            }

        }

        return res;

    }
}
