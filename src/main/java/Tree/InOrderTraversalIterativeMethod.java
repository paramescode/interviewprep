package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalIterativeMethod {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        while(root != null || stack.size() > 0){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode t = stack.pop();
            res.add(t.val);

            root = t.right;
        }
        return res;
    }
}
